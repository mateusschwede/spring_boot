package com.seuprojeto.cats.modules.auth.application.usecase
import com.seuprojeto.cats.modules.auth.interfaces.rest.dto.request.LoginRequest
import com.seuprojeto.cats.modules.auth.interfaces.rest.dto.request.RegisterRequest
import com.seuprojeto.cats.modules.auth.interfaces.rest.dto.response.AuthResponse

interface AuthUseCase {
    fun register(request: RegisterRequest): AuthResponse {
        val accessToken = jwtService.generateAccessToken(savedUser.username)
        val refreshToken = jwtService.generateRefreshToken(savedUser.username)

        return AuthResponse(
            accessToken = accessToken,
            refreshToken = refreshToken
        )
    }

    fun login(request: LoginRequest): AuthResponse {
        val accessToken = jwtService.generateAccessToken(user.username)
        val refreshToken = jwtService.generateRefreshToken(user.username)

        return AuthResponse(
            accessToken = accessToken,
            refreshToken = refreshToken
        )
    }

    fun refreshToken(refreshToken: String): String {
        if (!jwtService.isTokenValid(refreshToken)) {
            throw RuntimeException("Refresh token inválido")
        }

        val username = jwtService.extractUsername(refreshToken)
        return jwtService.generateAccessToken(username)
    }
}