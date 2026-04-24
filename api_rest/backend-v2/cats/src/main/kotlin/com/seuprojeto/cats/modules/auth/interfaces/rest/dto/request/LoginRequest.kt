package com.seuprojeto.cats.modules.auth.interfaces.rest.dto.request
import jakarta.validation.constraints.NotBlank

data class LoginRequest(

    @field:NotBlank(message = "Username é obrigatório")
    val username: String,

    @field:NotBlank(message = "Password é obrigatória")
    val password: String
)