package com.seuprojeto.cats.modules.cat.application.usecase
import com.seuprojeto.cats.modules.cat.domain.model.Cat
import com.seuprojeto.cats.modules.cat.domain.repository.CatRepository
import com.seuprojeto.cats.shared.exception.BusinessException
import org.springframework.stereotype.Service

@Service
class UpdateCatUseCase(
    private val repository: CatRepository
) {

    fun execute(id: Long, name: String): Cat {
        val cat = repository.findById(id)
            ?: throw BusinessException("Gato não encontrado: $id")

        cat.updateName(name)
        return repository.save(cat)
    }
}