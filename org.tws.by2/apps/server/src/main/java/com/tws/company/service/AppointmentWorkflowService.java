package com.tws.company.service;

import com.tws.company.domain.Appointment;
import com.tws.company.domain.enums.AppointmentType;
import com.tws.company.domain.enums.ServiceType;
import com.tws.company.repository.AppointmentRepository;
import com.tws.company.service.dto.AvailableDoctorResponse;
import com.tws.company.service.dto.AvailableTimeSlotResponse;
import com.tws.company.service.dto.CreateAppointmentRequest;
import com.tws.company.service.dto.CreateAppointmentResponse;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.UUID;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.tws.company.service.mapper.AppointmentWorkflowMapper;
import com.tws.company.service.mapper.EnumMapper;

@Service
public class AppointmentWorkflowService {

    private final AppointmentRepository appointmentRepository;
    private final DailyRoomService dailyRoomService;
    private final DatabaseClient databaseClient;
    private final AppointmentWorkflowMapper appointmentWorkflowMapper;

    public AppointmentWorkflowService(
        AppointmentRepository appointmentRepository,
        DailyRoomService dailyRoomService,
        DatabaseClient databaseClient,
        AppointmentWorkflowMapper appointmentWorkflowMapper
    ) {
        this.appointmentRepository = appointmentRepository;
        this.dailyRoomService = dailyRoomService;
        this.databaseClient = databaseClient;
        this.appointmentWorkflowMapper = appointmentWorkflowMapper;
    }

    @Transactional
    public Mono<CreateAppointmentResponse> createAppointment(CreateAppointmentRequest request) {
        if (
            request.patientName() == null ||
            request.doctorProfileId() == null ||
            request.doctorName() == null ||
            request.specialty() == null ||
            request.appointmentDate() == null ||
            request.appointmentType() == null
        ) {
            return Mono.error(new IllegalArgumentException("Dados para o agendamento estao incompletos."));
        }

        AppointmentType appointmentType = parseAppointmentType(request.appointmentType());

        Mono<String> roomUrlMono = appointmentType == AppointmentType.TELEMEDICINA
            ? dailyRoomService.createRoom(request.appointmentDate().plus(2, ChronoUnit.HOURS), false)
            : Mono.justOrEmpty((String) null);

        return roomUrlMono.defaultIfEmpty("")
            .flatMap(roomUrl -> {
                Appointment appointment = appointmentWorkflowMapper.toEntity(request, appointmentType, roomUrl);
                return appointmentRepository.save(appointment).map(saved -> new CreateAppointmentResponse(saved.getId(), saved.getTelemedicineRoomUrl()));
            });
    }

    @Transactional(readOnly = true)
    public Mono<AvailableDoctorResponse> findAvailableDoctor(String specialty) {
        if (specialty == null || specialty.isBlank()) {
            return Mono.error(new IllegalArgumentException("A especialidade e obrigatoria."));
        }

        return databaseClient
            .sql(
                """
                SELECT dp.id AS doctor_profile_id, ua.display_name
                FROM doctor_profile dp
                JOIN user_account ua ON ua.id = dp.user_account_id
                JOIN doctor_profile_specialty dps ON dps.doctor_profile_id = dp.id
                WHERE lower(dps.specialty) = :specialty
                  AND ua.user_type = 'doctor'
                  AND ua.status = 'ACTIVE'
                LIMIT 1
                """
            )
            .bind("specialty", specialty.toLowerCase(Locale.ROOT))
            .map((row, metadata) -> new AvailableDoctorResponse(row.get("doctor_profile_id", UUID.class), row.get("display_name", String.class)))
            .one();
    }

    @Transactional(readOnly = true)
    public Flux<AvailableTimeSlotResponse> getAvailableSlotsForSpecialty(String specialty) {
        if (specialty == null || specialty.isBlank()) {
            return Flux.error(new IllegalArgumentException("A especialidade e obrigatoria."));
        }

        return databaseClient
            .sql(
                """
                SELECT dts.id AS doctor_time_slot_id, dts.doctor_profile_id, dts.doctor_name, dts.slot_date, dts.start_time, dts.end_time
                FROM doctor_time_slot dts
                JOIN doctor_time_slot_specialty dtss ON dtss.doctor_time_slot_id = dts.id
                WHERE dts.status = 'AVAILABLE'
                  AND dts.service_type = :serviceType
                  AND dts.slot_date >= CURRENT_DATE
                  AND lower(dtss.specialty) = :specialty
                ORDER BY dts.slot_date ASC, dts.start_time ASC
                LIMIT 20
                """
            )
            .bind("serviceType", EnumMapper.toValue(ServiceType.TELEMEDICINA))
            .bind("specialty", specialty.toLowerCase(Locale.ROOT))
            .map(
                (row, metadata) ->
                    new AvailableTimeSlotResponse(
                        row.get("doctor_time_slot_id", UUID.class),
                        row.get("doctor_profile_id", UUID.class),
                        row.get("doctor_name", String.class),
                        row.get("slot_date", java.time.LocalDate.class),
                        row.get("start_time", java.time.LocalTime.class),
                        row.get("end_time", java.time.LocalTime.class)
                    )
            )
            .all();
    }

    @Transactional
    public Mono<Appointment> saveAiAnalysis(UUID appointmentId, String aiAnalysisReport) {
        return appointmentRepository.findById(appointmentId).flatMap(appointment -> {
            appointment.setAiAnalysisReport(aiAnalysisReport);
            return appointmentRepository.save(appointment);
        });
    }

    private AppointmentType parseAppointmentType(String value) {
        if (EnumMapper.equalsValue(value, AppointmentType.TELEMEDICINA)) {
            return AppointmentType.TELEMEDICINA;
        }
        return AppointmentType.PRESENCIAL;
    }
}
