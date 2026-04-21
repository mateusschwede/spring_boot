package com.seuprojeto.cats.modules.auth.application
import com.seuprojeto.cats.shared.security.JwtService
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.stereotype.Service

@Service
class AuthService(
    private val authenticationManager: AuthenticationManager,
    private val jwtService: JwtService
) {

    fun login(username: String, password: String): String {

        val auth = authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(username, password)
        )

        val user = auth.principal as org.springframework.security.core.userdetails.User
        return jwtService.generateToken(user.username)
    }
}