package com.seuprojeto.cats.modules.cat.interfaces.rest
import com.seuprojeto.cats.modules.cat.application.usecase.*
import com.seuprojeto.cats.modules.cat.interfaces.rest.dto.request.CreateCatRequest
import com.seuprojeto.cats.modules.cat.interfaces.rest.dto.request.UpdateCatRequest
import com.seuprojeto.cats.modules.cat.interfaces.rest.mapper.CatDtoMapper
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import io.swagger.v3.oas.annotations.responses.ApiResponse
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/cats")
@Tag(name = "Cats", description = "Gerenciamento de gatos para adoção")
class CatController(
    private val create: CreateCatUseCase,
    private val update: UpdateCatUseCase,
    private val delete: DeleteCatUseCase,
    private val list: ListCatsUseCase,
    private val get: GetCatUseCase,
    private val adopt: AdoptCatUseCase,
    private val unadopt: UnadoptCatUseCase
) {

    @Operation(summary = "Criar um novo gato")
    @ApiResponse(responseCode = "201", description = "Gato criado com sucesso")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody @Valid request: CreateCatRequest) =
        CatDtoMapper.toResponse(create.execute(request.name))

    @Operation(summary = "Atualizar nome do gato")
    @ApiResponse(responseCode = "200", description = "Gato atualizado com sucesso")
    @PutMapping("/{id}")
    fun update(
        @PathVariable id: Long,
        @RequestBody @Valid request: UpdateCatRequest
    ) = CatDtoMapper.toResponse(update.execute(id, request.name))

    @Operation(summary = "Deletar um gato")
    @ApiResponse(responseCode = "204", description = "Gato removido com sucesso")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long) {
        delete.execute(id)
    }

    @Operation(summary = "Listar todos os gatos")
    @GetMapping
    fun list() =
        CatDtoMapper.toResponseList(list.execute())

    @Operation(summary = "Buscar gato por ID")
    @GetMapping("/{id}")
    fun get(@PathVariable id: Long) =
        CatDtoMapper.toResponse(get.execute(id))

    @Operation(summary = "Adotar um gato")
    @PostMapping("/{id}/adopt")
    fun adopt(@PathVariable id: Long) =
        CatDtoMapper.toResponse(adopt.execute(id))

    @Operation(summary = "Desfazer adoção do gato")
    @PostMapping("/{id}/unadopt")
    fun unadopt(@PathVariable id: Long) =
        CatDtoMapper.toResponse(unadopt.execute(id))
}