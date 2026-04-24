package com.seuprojeto.cats.modules.auth.interfaces.rest
import com.seuprojeto.cats.modules.auth.application.usecase.AuthUseCase
import com.seuprojeto.cats.modules.auth.interfaces.rest.dto.request.LoginRequest
import com.seuprojeto.cats.modules.auth.interfaces.rest.dto.request.RegisterRequest
import com.seuprojeto.cats.modules.auth.interfaces.rest.dto.response.AuthResponse
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/auth")
class AuthController(
    private val authUseCase: AuthUseCase
) {

    @PostMapping("/register")
    fun register(
        @Valid @RequestBody request: RegisterRequest
    ): ResponseEntity<AuthResponse> {

        val response = authUseCase.register(request)
        return ResponseEntity.ok(response)
    }

    @PostMapping("/login")
    fun login(
        @Valid @RequestBody request: LoginRequest
    ): ResponseEntity<AuthResponse> {

        val response = authUseCase.login(request)
        return ResponseEntity.ok(response)
    }

    @GetMapping("/ping")
    fun ping(): String {
        return "auth ok"
    }

    @PostMapping("/refresh")
    fun refresh(
        @RequestBody request: RefreshTokenRequest
    ): ResponseEntity<RefreshTokenResponse> {

        val newAccessToken = authUseCase.refreshToken(request.refreshToken)
        return ResponseEntity.ok(
            RefreshTokenResponse(newAccessToken)
        )
    }
}