package com.ventas.code.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ventas.code.repository.UsuarioRepository;
import com.ventas.code.utils.UsuarioResponse;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioRepository userRepository;

    @GetMapping
    public List<UsuarioResponse> changePassword() {
        return userRepository.findAll()
                .stream()
                .map(user -> new UsuarioResponse(user.getNombre(), user.getEmail()))
                .toList();
    }
}
