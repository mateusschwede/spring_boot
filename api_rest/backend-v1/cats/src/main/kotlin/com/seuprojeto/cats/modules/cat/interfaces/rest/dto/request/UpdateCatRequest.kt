package com.seuprojeto.cats.modules.cat.interfaces.rest.dto.request
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.NotBlank

data class UpdateCatRequest(

    @field:NotBlank(message = "Name must not be blank")
    @field:Schema(
        description = "Novo nome do gato",
        example = "Garfield"
    )
    val name: String
)