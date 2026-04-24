package com.seuprojeto.cats.modules.cat.domain.repository
import com.seuprojeto.cats.modules.cat.domain.model.Cat

interface CatRepository {
    fun save(cat: Cat): Cat
    fun findById(id: Long): Cat?
    fun findAll(): List<Cat>
    fun deleteById(id: Long)
}