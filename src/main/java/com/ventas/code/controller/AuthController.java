package com.ventas.code.controller;

import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ventas.code.service.AuthService;
import com.ventas.code.utils.AuthRequest;
import com.ventas.code.utils.RegisterRequest;
import com.ventas.code.utils.ResponseMessage;
import com.ventas.code.utils.TokenResponse;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    
    private static  final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

    private final AuthService service;

    @PostMapping("/register")
    public ResponseEntity<TokenResponse> register(@RequestBody RegisterRequest request) {
        final TokenResponse response = service.register(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseMessage> authenticate(@RequestBody AuthRequest request) {
        //final TokenResponse response = service.authenticate(request);
        return service.authenticate(request);
        //return ResponseEntity.ok(response);
    }

    @PostMapping("/refresh-token")
    public TokenResponse refreshToken(
            @RequestHeader(HttpHeaders.AUTHORIZATION) final String authentication
    ) {
        return service.refreshToken(authentication);
    }


}
