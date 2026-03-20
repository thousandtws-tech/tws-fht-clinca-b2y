package com.tws.company.service.dto;

import java.util.List;
import java.util.UUID;

public record SearchAssociatedDoctorsRequest(UUID hospitalProfileId, String searchTerm, List<String> specialties) {}
