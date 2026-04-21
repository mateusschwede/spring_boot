package com.seuprojeto.cats.modules.cat.application.usecase
import com.seuprojeto.cats.modules.cat.domain.repository.CatRepository
import com.seuprojeto.cats.shared.exception.BusinessException
import org.springframework.stereotype.Service

@Service
class DeleteCatUseCase(
    private val repository: CatRepository
) {

    fun execute(id: Long) {
        val cat = repository.findById(id)
            ?: throw BusinessException("Gato não encontrado: $id")

        repository.deleteById(cat.id!!)
    }
}