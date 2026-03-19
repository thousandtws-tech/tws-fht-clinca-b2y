package com.tws.company.web.rest;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
@RestController
@RequestMapping("/api/authtest")
@Hidden
public class AuthTest {

    @PreAuthorize("hasAuthority('ROLE_DOCTOR')")
    @GetMapping()
    public Mono<String> home() {
        return Mono.just("Home");
    }
}
