package com.tws.company.service.mapper;

import com.tws.company.domain.Appointment;
import com.tws.company.domain.enums.AppointmentStatus;
import com.tws.company.domain.enums.AppointmentType;
import com.tws.company.service.dto.CreateAppointmentRequest;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class AppointmentWorkflowMapper {

    public Appointment toEntity(CreateAppointmentRequest request, AppointmentType appointmentType, String roomUrl) {
        Appointment appointment = new Appointment();
        appointment.setId(UUID.randomUUID());
        appointment.setPatientId(request.patientId());
        appointment.setPatientName(request.patientName());
        appointment.setDoctorProfileId(request.doctorProfileId());
        appointment.setDoctorName(request.doctorName());
        appointment.setSpecialty(request.specialty());
        appointment.setAppointmentType(EnumMapper.toValue(appointmentType));
        appointment.setAppointmentDate(request.appointmentDate());
        appointment.setStatus(EnumMapper.toValue(AppointmentStatus.SCHEDULED));
        appointment.setTelemedicineRoomUrl(roomUrl == null || roomUrl.isBlank() ? null : roomUrl);
        appointment.setCreatedByUserAccountId(request.createdByUserAccountId());
        appointment.setCreatedBy("system");
        appointment.setLastModifiedBy("system");
        return appointment;
    }
}
