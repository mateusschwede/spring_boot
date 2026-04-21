package com.seuprojeto.cats.modules.cat.application.usecase
import com.seuprojeto.cats.modules.cat.domain.model.Cat
import com.seuprojeto.cats.modules.cat.domain.repository.CatRepository
import com.seuprojeto.cats.shared.exception.BusinessException
import org.springframework.stereotype.Service

@Service
class UnadoptCatUseCase(
    private val repository: CatRepository
) {

    fun execute(id: Long): Cat {
        val cat = repository.findById(id)
            ?: throw BusinessException("Gato não encontrado: $id")

        cat.unadopt()
        return repository.save(cat)
    }
}