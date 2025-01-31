package com.ventas.code.utils;

public record AuthRequest(
        String email,
        String password
) {
}
