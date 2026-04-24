package com.seuprojeto.cats.modules.cat.infrastructure.persistence.adapter
import com.seuprojeto.cats.modules.cat.domain.model.Cat
import com.seuprojeto.cats.modules.cat.domain.repository.CatRepository
import com.seuprojeto.cats.modules.cat.infrastructure.persistence.entity.CatEntity
import com.seuprojeto.cats.modules.cat.infrastructure.persistence.repository.JpaCatRepository
import org.springframework.stereotype.Component

@Component
class CatRepositoryImpl(
    private val jpaRepository: JpaCatRepository
) : CatRepository {

    override fun save(cat: Cat): Cat {
        val entity = CatEntity(
            id = cat.id,
            name = cat.name,
            adopted = cat.adopted
        )
        val saved = jpaRepository.save(entity)
        return Cat(
            id = saved.id,
            name = saved.name,
            adopted = saved.adopted
        )
    }

    override fun findById(id: Long): Cat? {
        return jpaRepository.findById(id)
            .map { Cat(it.id, it.name, it.adopted) }
            .orElse(null)
    }

    override fun findAll(): List<Cat> {
        return jpaRepository.findAll()
            .map { Cat(it.id, it.name, it.adopted) }
    }

    override fun deleteById(id: Long) {
        jpaRepository.deleteById(id)
    }
}