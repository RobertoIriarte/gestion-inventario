package com.ventas.code.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ventas.code.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    public Optional<Usuario> findByEmail(String email);
    
}
