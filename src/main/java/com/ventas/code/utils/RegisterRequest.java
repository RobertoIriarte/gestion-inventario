package com.ventas.code.utils;

public record RegisterRequest(
        String name,
        String email,
        String password
) {
}
