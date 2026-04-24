package com.seuprojeto.cats.modules.auth.interfaces.rest.dto.request
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class RegisterRequest(

    @field:NotBlank(message = "Username é obrigatório")
    @field:Size(min = 3, max = 50, message = "Username deve ter entre 3 e 50 caracteres")
    val username: String,

    @field:NotBlank(message = "Password é obrigatória")
    @field:Size(min = 6, message = "Password deve ter no mínimo 6 caracteres")
    val password: String
)