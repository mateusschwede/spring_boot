package com.example.myjwt.controller

import com.example.myjwt.dto.LoginRequest
import com.example.myjwt.dto.TokenResponse
import com.example.myjwt.security.JwtService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/auth")
class AuthController(
    private val jwtService: JwtService
) {

    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest): TokenResponse {

        if (request.username != "admin" || request.password != "123") {
            throw RuntimeException("Invalid credentials")
        }

        val accessToken = jwtService.generateAccessToken(request.username)
        val refreshToken = jwtService.generateRefreshToken(request.username)

        return TokenResponse(
            accessToken = accessToken,
            refreshToken = refreshToken
        )
    }
}