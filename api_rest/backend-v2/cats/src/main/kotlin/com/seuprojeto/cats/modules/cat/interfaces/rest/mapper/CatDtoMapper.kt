package com.seuprojeto.cats.modules.cat.interfaces.rest.mapper
import com.seuprojeto.cats.modules.cat.domain.model.Cat
import com.seuprojeto.cats.modules.cat.interfaces.rest.dto.response.CatResponse

object CatDtoMapper {

    fun toResponse(cat: Cat): CatResponse =
        CatResponse(
            id = cat.id,
            name = cat.name,
            adopted = cat.adopted
        )

    fun toResponseList(cats: List<Cat>): List<CatResponse> =
        cats.map { toResponse(it) }
}