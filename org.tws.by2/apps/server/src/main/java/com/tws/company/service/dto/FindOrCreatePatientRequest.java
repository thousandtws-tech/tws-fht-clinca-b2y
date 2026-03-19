package com.tws.company.service.dto;

import java.time.LocalDate;

public record FindOrCreatePatientRequest(String cpf, String name, LocalDate birthDate, String phone, String email) {}
