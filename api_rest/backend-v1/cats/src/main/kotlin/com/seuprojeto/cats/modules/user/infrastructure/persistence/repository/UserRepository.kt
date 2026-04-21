package com.seuprojeto.cats.modules.user.infrastructure.persistence.repository
import com.seuprojeto.cats.modules.user.infrastructure.persistence.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<UserEntity, Long> {
    fun findByUsername(username: String): UserEntity?
}