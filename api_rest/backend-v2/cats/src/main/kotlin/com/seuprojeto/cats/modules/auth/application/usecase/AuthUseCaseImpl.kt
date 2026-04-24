package com.seuprojeto.cats.modules.auth.application.usecase
import com.seuprojeto.cats.modules.auth.interfaces.rest.dto.request.LoginRequest
import com.seuprojeto.cats.modules.auth.interfaces.rest.dto.request.RegisterRequest
import com.seuprojeto.cats.modules.auth.interfaces.rest.dto.response.AuthResponse
import com.seuprojeto.cats.modules.user.infrastructure.persistence.entity.UserEntity
import com.seuprojeto.cats.modules.user.infrastructure.persistence.repository.UserRepository
import com.seuprojeto.cats.shared.security.JwtService
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthUseCaseImpl(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtService: JwtService,
    private val authenticationManager: AuthenticationManager
) : AuthUseCase {

    override fun register(request: RegisterRequest): AuthResponse {

        if (userRepository.existsByUsername(request.username)) {
            throw RuntimeException("Usuário já existe")
        }

        val user = UserEntity(
            username = request.username,
            password = passwordEncoder.encode(request.password)
        )

        val savedUser = userRepository.save(user)

        val token = jwtService.generateToken(savedUser.username)

        return AuthResponse(
            accessToken = token
        )
    }

    override fun login(request: LoginRequest): AuthResponse {

        val authentication = UsernamePasswordAuthenticationToken(
            request.username,
            request.password
        )

        authenticationManager.authenticate(authentication)

        val user = userRepository.findByUsername(request.username)
            .orElseThrow { RuntimeException("Usuário não encontrado") }

        val token = jwtService.generateToken(user.username)

        return AuthResponse(
            accessToken = token
        )
    }
}