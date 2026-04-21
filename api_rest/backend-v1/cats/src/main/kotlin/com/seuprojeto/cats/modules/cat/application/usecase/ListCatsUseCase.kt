package com.seuprojeto.cats.modules.cat.application.usecase
import com.seuprojeto.cats.modules.cat.domain.model.Cat
import com.seuprojeto.cats.modules.cat.domain.repository.CatRepository
import org.springframework.stereotype.Service

@Service
class ListCatsUseCase(
    private val repository: CatRepository
) {

    fun execute(): List<Cat> {
        return repository.findAll()
    }
}