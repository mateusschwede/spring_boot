package com.seuprojeto.cats.modules.cat.infrastructure.persistence.repository
import com.seuprojeto.cats.modules.cat.infrastructure.persistence.entity.CatEntity
import org.springframework.data.jpa.repository.JpaRepository

interface JpaCatRepository : JpaRepository<CatEntity, Long>