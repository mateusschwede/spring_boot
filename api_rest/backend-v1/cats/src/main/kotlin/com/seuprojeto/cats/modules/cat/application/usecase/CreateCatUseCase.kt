package com.seuprojeto.cats.modules.cat.application.usecase
import com.seuprojeto.cats.modules.cat.domain.model.Cat
import com.seuprojeto.cats.modules.cat.domain.repository.CatRepository
import org.springframework.stereotype.Service

@Service
class CreateCatUseCase(
    private val repository: CatRepository
) {

    fun execute(name: String): Cat {
        val cat = Cat(
            name = name
        )
        return repository.save(cat)
    }
}