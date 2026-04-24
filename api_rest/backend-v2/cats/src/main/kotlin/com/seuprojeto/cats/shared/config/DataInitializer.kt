package com.seuprojeto.cats.shared.config
import com.seuprojeto.cats.modules.user.infrastructure.persistence.entity.UserEntity
import com.seuprojeto.cats.modules.user.infrastructure.persistence.repository.UserRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class DataInitializer(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) : CommandLineRunner {

    override fun run(vararg args: String?) {

        if (userRepository.findByUsername("admin") == null) {
            userRepository.save(
                UserEntity(
                    username = "admin",
                    password = passwordEncoder.encode("123")
                )
            )
        }
    }
}