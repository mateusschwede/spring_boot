package com.seuprojeto.cats.modules.auth.interfaces.rest.dto.request
import jakarta.validation.constraints.NotBlank

data class RefreshTokenRequest(

    @field:NotBlank
    val refreshToken: String
)