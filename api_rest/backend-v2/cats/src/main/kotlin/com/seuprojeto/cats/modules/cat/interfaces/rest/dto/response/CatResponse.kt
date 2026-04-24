package com.seuprojeto.cats.modules.cat.interfaces.rest.dto.response
import io.swagger.v3.oas.annotations.media.Schema

data class CatResponse(

    @Schema(description = "ID do gato", example = "1")
    val id: Long?,

    @Schema(description = "Nome do gato", example = "Mingau")
    val name: String,

    @Schema(description = "Indica se o gato foi adotado", example = "false")
    val adopted: Boolean
)