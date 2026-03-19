package com.tws.company.domain;

import com.tws.company.domain.enums.UserStatus;
import com.tws.company.domain.enums.UserType;

import java.time.LocalDate;
import java.util.List;

public class Appointments {
    @Id
    @org.springframework.data.elasticsearch.annotations.Field(type = FieldType.Keyword)
    @Column("id")

    String patientId;
    String patientName;
    String doctorId;
    String doctorName;
    List<String>  specialty;
    UserType type;
    LocalDate appointmentDate;
    UserStatus status;
    String telemedicineRoomUrl;
    String aiAnalysisReport;
    String createdBy;
}
