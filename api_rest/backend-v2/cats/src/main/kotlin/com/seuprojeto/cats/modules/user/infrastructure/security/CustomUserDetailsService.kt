package com.seuprojeto.cats.modules.user.infrastructure.security
import com.seuprojeto.cats.modules.user.infrastructure.persistence.repository.UserRepository
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService(
    private val userRepository: UserRepository
) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {

        val user = userRepository.findByUsername(username)
            .orElseThrow { UsernameNotFoundException("Usuário não encontrado") }

        return User.builder()
            .username(user.username)
            .password(user.password)
            .authorities(emptyList())
            .build()
    }
}