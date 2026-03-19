package com.tws.company.domain;

import com.tws.company.domain.enums.UserStatus;

import java.util.List;

public class Invitations {
    String userId;
    String professionalCrm;
    List<String> specialties;
    Integer desiredHourlyRate;
    UserStatus status;
    List<String> healthUnitIds;
}
