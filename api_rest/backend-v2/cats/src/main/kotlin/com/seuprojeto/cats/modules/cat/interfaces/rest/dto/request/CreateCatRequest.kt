package com.seuprojeto.cats.modules.cat.interfaces.rest.dto.request
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.NotBlank

data class CreateCatRequest(

    @field:NotBlank(message = "Nome do gato não pode ser vazio")
    @field:Schema(
        description = "Nome do gato",
        example = "Mingau"
    )
    val name: String
)