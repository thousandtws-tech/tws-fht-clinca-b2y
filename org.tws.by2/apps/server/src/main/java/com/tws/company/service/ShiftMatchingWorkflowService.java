package com.tws.company.service;

import com.tws.company.domain.DoctorTimeSlot;
import com.tws.company.domain.PotentialMatch;
import com.tws.company.domain.ShiftRequirement;
import com.tws.company.domain.enums.PotentialMatchStatus;
import com.tws.company.domain.enums.ShiftRequirementStatus;
import com.tws.company.repository.DoctorTimeSlotRepository;
import com.tws.company.repository.PotentialMatchRepository;
import com.tws.company.repository.ShiftRequirementRepository;
import com.tws.company.service.mapper.EnumMapper;
import com.tws.company.service.support.TimeSlotUtils;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ShiftMatchingWorkflowService {

    private final ShiftRequirementRepository shiftRequirementRepository;
    private final DoctorTimeSlotRepository doctorTimeSlotRepository;
    private final PotentialMatchRepository potentialMatchRepository;
    private final DatabaseClient databaseClient;

    public ShiftMatchingWorkflowService(
        ShiftRequirementRepository shiftRequirementRepository,
        DoctorTimeSlotRepository doctorTimeSlotRepository,
        PotentialMatchRepository potentialMatchRepository,
        DatabaseClient databaseClient
    ) {
        this.shiftRequirementRepository = shiftRequirementRepository;
        this.doctorTimeSlotRepository = doctorTimeSlotRepository;
        this.potentialMatchRepository = potentialMatchRepository;
        this.databaseClient = databaseClient;
    }

    @Transactional
    public Flux<PotentialMatch> rebuildMatches(UUID shiftRequirementId) {
        return deletePendingMatchesByRequirement(shiftRequirementId)
            .thenMany(
                shiftRequirementRepository
                    .findById(shiftRequirementId)
                    .filter(requirement -> EnumMapper.equalsValue(requirement.getStatus(), ShiftRequirementStatus.OPEN))
                    .flatMapMany(requirement -> {
                        Mono<List<LocalDate>> datesMono = loadRequirementDates(shiftRequirementId).collectList();
                        Mono<List<String>> specialtiesMono = loadRequirementSpecialties(shiftRequirementId).collectList();
                        Mono<List<String>> citiesMono = loadRequirementCities(shiftRequirementId).collectList();

                        return Mono.zip(datesMono, specialtiesMono, citiesMono).flatMapMany(tuple ->
                            findCandidateSlots(requirement.getState(), tuple.getT1()).flatMap(slot ->
                                Mono.zip(loadSlotSpecialties(slot.getId()).collectList(), loadSlotCities(slot.getId()).collectList())
                                    .filter(data -> matches(requirement, tuple.getT1(), tuple.getT2(), tuple.getT3(), slot, data.getT1(), data.getT2()))
                                    .flatMapMany(data ->
                                        createPotentialMatches(requirement, tuple.getT1(), tuple.getT2(), tuple.getT3(), slot, data.getT1(), data.getT2())
                                    )
                            )
                        );
                    })
            );
    }

    @Transactional
    public Mono<Void> deletePendingMatchesByRequirement(UUID shiftRequirementId) {
        return databaseClient
            .sql("DELETE FROM potential_match WHERE shift_requirement_id = :id AND status = :status")
            .bind("id", shiftRequirementId)
            .bind("status", EnumMapper.toValue(PotentialMatchStatus.PENDING_BACKOFFICE_REVIEW))
            .then();
    }

    @Transactional
    public Mono<Void> deletePendingMatchesByTimeSlot(UUID doctorTimeSlotId) {
        return databaseClient
            .sql("DELETE FROM potential_match WHERE doctor_time_slot_id = :id AND status = :status")
            .bind("id", doctorTimeSlotId)
            .bind("status", EnumMapper.toValue(PotentialMatchStatus.PENDING_BACKOFFICE_REVIEW))
            .then();
    }

    private Flux<PotentialMatch> createPotentialMatches(
        ShiftRequirement requirement,
        List<LocalDate> requirementDates,
        List<String> requirementSpecialties,
        List<String> requirementCities,
        DoctorTimeSlot slot,
        List<String> slotSpecialties,
        List<String> slotCities
    ) {
        return Flux.fromIterable(requirementDates)
            .filter(date -> date.equals(slot.getSlotDate()))
            .map(date -> buildPotentialMatch(requirement, requirementSpecialties, requirementCities, slot, slotSpecialties, slotCities, date))
            .flatMap(potentialMatchRepository::save);
    }

    private PotentialMatch buildPotentialMatch(
        ShiftRequirement requirement,
        List<String> requirementSpecialties,
        List<String> requirementCities,
        DoctorTimeSlot slot,
        List<String> slotSpecialties,
        List<String> slotCities,
        LocalDate matchedDate
    ) {
        PotentialMatch match = new PotentialMatch();
        match.setId(UUID.randomUUID());
        match.setShiftRequirementId(requirement.getId());
        match.setDoctorTimeSlotId(slot.getId());
        match.setDoctorProfileId(slot.getDoctorProfileId());
        match.setHospitalProfileId(requirement.getHospitalProfileId());
        match.setMatchedDate(matchedDate);
        match.setStatus(EnumMapper.toValue(PotentialMatchStatus.PENDING_BACKOFFICE_REVIEW));
        match.setOfferedRateByHospital(requirement.getOfferedRate());
        match.setDoctorDesiredRate(slot.getDesiredHourlyRate());
        match.setMatchScore(calculateMatchScore(requirement, requirementSpecialties, requirementCities, slot, slotSpecialties, slotCities));
        match.setCreatedBy("system");
        match.setLastModifiedBy("system");
        return match;
    }

    private Integer calculateMatchScore(
        ShiftRequirement requirement,
        List<String> requirementSpecialties,
        List<String> requirementCities,
        DoctorTimeSlot slot,
        List<String> slotSpecialties,
        List<String> slotCities
    ) {
        int score = 0;

        long specialtyMatches = slotSpecialties
            .stream()
            .map(value -> value.toLowerCase(Locale.ROOT))
            .filter(specialty -> requirementSpecialties.stream().map(value -> value.toLowerCase(Locale.ROOT)).anyMatch(specialty::equals))
            .count();

        if (specialtyMatches > 0) {
            score += 5;
            if (specialtyMatches == requirementSpecialties.size()) {
                score += 3;
            }
        }

        if (requirement.getServiceType() != null && requirement.getServiceType().equalsIgnoreCase(slot.getServiceType())) {
            score += 3;
        }

        if (
            slot.getDesiredHourlyRate() != null &&
            requirement.getOfferedRate() != null &&
            slot.getDesiredHourlyRate().compareTo(requirement.getOfferedRate()) <= 0
        ) {
            score += 4;
        }

        long cityMatches = slotCities
            .stream()
            .map(value -> value.toLowerCase(Locale.ROOT))
            .filter(city -> requirementCities.stream().map(value -> value.toLowerCase(Locale.ROOT)).anyMatch(city::equals))
            .count();
        if (cityMatches > 0) {
            score += 2;
        }

        return score;
    }

    private boolean matches(
        ShiftRequirement requirement,
        List<LocalDate> requirementDates,
        List<String> requirementSpecialties,
        List<String> requirementCities,
        DoctorTimeSlot slot,
        List<String> slotSpecialties,
        List<String> slotCities
    ) {
        boolean sameDate = requirementDates.stream().anyMatch(date -> date.equals(slot.getSlotDate()));
        if (!sameDate) {
            return false;
        }

        boolean specialtyMatch =
            requirementSpecialties.isEmpty() ||
            slotSpecialties.stream().map(value -> value.toLowerCase(Locale.ROOT)).anyMatch(specialty ->
                requirementSpecialties.stream().map(value -> value.toLowerCase(Locale.ROOT)).anyMatch(specialty::equals)
            );
        if (!specialtyMatch) {
            return false;
        }

        boolean cityMatch =
            requirementCities.isEmpty() ||
            slotCities.stream().map(value -> value.toLowerCase(Locale.ROOT)).anyMatch(city ->
                requirementCities.stream().map(value -> value.toLowerCase(Locale.ROOT)).anyMatch(city::equals)
            );
        if (!cityMatch) {
            return false;
        }

        return TimeSlotUtils.doIntervalsOverlap(
            requirement.getStartTime(),
            requirement.getEndTime(),
            requirement.isOvernight(),
            slot.getStartTime(),
            slot.getEndTime(),
            slot.isOvernight()
        );
    }

    private Flux<DoctorTimeSlot> findCandidateSlots(String state, List<LocalDate> dates) {
        if (dates.isEmpty()) {
            return Flux.empty();
        }

        return Flux.fromIterable(dates)
            .flatMap(date ->
                databaseClient
                    .sql(
                        """
                        SELECT * FROM doctor_time_slot
                        WHERE status = 'AVAILABLE'
                          AND state = :state
                          AND slot_date = :slotDate
                        """
                    )
                    .bind("state", state)
                    .bind("slotDate", date)
                    .map((row, metadata) -> {
                        DoctorTimeSlot slot = new DoctorTimeSlot();
                        slot.setId(row.get("id", UUID.class));
                        slot.setDoctorProfileId(row.get("doctor_profile_id", UUID.class));
                        slot.setDoctorName(row.get("doctor_name", String.class));
                        slot.setSlotDate(row.get("slot_date", LocalDate.class));
                        slot.setStartTime(row.get("start_time", LocalTime.class));
                        slot.setEndTime(row.get("end_time", LocalTime.class));
                        slot.setOvernight(Boolean.TRUE.equals(row.get("is_overnight", Boolean.class)));
                        slot.setServiceType(row.get("service_type", String.class));
                        slot.setDesiredHourlyRate(row.get("desired_hourly_rate", BigDecimal.class));
                        slot.setStatus(row.get("status", String.class));
                        slot.setNotes(row.get("notes", String.class));
                        slot.setState(row.get("state", String.class));
                        return slot;
                    })
                    .all()
            )
            .distinct(DoctorTimeSlot::getId);
    }

    private Flux<LocalDate> loadRequirementDates(UUID requirementId) {
        return databaseClient
            .sql("SELECT shift_date FROM shift_requirement_date WHERE shift_requirement_id = :id ORDER BY shift_date")
            .bind("id", requirementId)
            .map((row, metadata) -> row.get("shift_date", LocalDate.class))
            .all();
    }

    private Flux<String> loadRequirementSpecialties(UUID requirementId) {
        return databaseClient
            .sql("SELECT specialty FROM shift_requirement_specialty WHERE shift_requirement_id = :id ORDER BY specialty")
            .bind("id", requirementId)
            .map((row, metadata) -> row.get("specialty", String.class))
            .all();
    }

    private Flux<String> loadRequirementCities(UUID requirementId) {
        return databaseClient
            .sql("SELECT city FROM shift_requirement_city WHERE shift_requirement_id = :id ORDER BY city")
            .bind("id", requirementId)
            .map((row, metadata) -> row.get("city", String.class))
            .all();
    }

    private Flux<String> loadSlotSpecialties(UUID slotId) {
        return databaseClient
            .sql("SELECT specialty FROM doctor_time_slot_specialty WHERE doctor_time_slot_id = :id ORDER BY specialty")
            .bind("id", slotId)
            .map((row, metadata) -> row.get("specialty", String.class))
            .all();
    }

    private Flux<String> loadSlotCities(UUID slotId) {
        return databaseClient
            .sql("SELECT city FROM doctor_time_slot_city WHERE doctor_time_slot_id = :id ORDER BY city")
            .bind("id", slotId)
            .map((row, metadata) -> row.get("city", String.class))
            .all();
    }
}
