package com.seuprojeto.cats.modules.auth.interfaces.rest.dto.response

data class AuthResponse(
    val accessToken: String,
    val refreshToken: String
)