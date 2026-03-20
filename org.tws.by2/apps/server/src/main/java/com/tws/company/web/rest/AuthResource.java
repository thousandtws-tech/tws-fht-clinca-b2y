package com.tws.company.web.rest;

import com.tws.company.service.auth.AuthOrchestrationService;
import com.tws.company.service.dto.auth.AuthResponse;
import com.tws.company.service.dto.auth.LoginRequest;
import com.tws.company.service.dto.auth.RegisterDoctorRequest;
import com.tws.company.service.dto.auth.RegisterHospitalRequest;
import com.tws.company.service.dto.auth.RegisterUserRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/auth")
public class AuthResource {

    private final AuthOrchestrationService authOrchestrationService;

    public AuthResource(AuthOrchestrationService authOrchestrationService) {
        this.authOrchestrationService = authOrchestrationService;
    }

    @PostMapping("/login")
    public Mono<AuthResponse> login(@Valid @RequestBody LoginRequest request) {
        return authOrchestrationService.login(request);
    }

    @PostMapping("/register/user")
    public Mono<AuthResponse> registerUser(@Valid @RequestBody RegisterUserRequest request) {
        return authOrchestrationService.registerUser(request);
    }

    @PostMapping("/register/doctor")
    public Mono<AuthResponse> registerDoctor(@Valid @RequestBody RegisterDoctorRequest request) {
        return authOrchestrationService.registerDoctor(request);
    }

    @PostMapping("/register/hospital")
    public Mono<AuthResponse> registerHospital(@Valid @RequestBody RegisterHospitalRequest request) {
        return authOrchestrationService.registerHospital(request);
    }
}
