package com.seuprojeto.cats.modules.auth.interfaces.rest
import com.seuprojeto.cats.modules.auth.application.AuthService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/auth")
class AuthController(
    private val authService: AuthService
) {

    data class LoginRequest(
        val username: String,
        val password: String
    )

    data class LoginResponse(
        val token: String
    )

    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest): LoginResponse {
        val token = authService.login(request.username, request.password)
        return LoginResponse(token)
    }
}