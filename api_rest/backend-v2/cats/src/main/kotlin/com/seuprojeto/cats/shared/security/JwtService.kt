package com.seuprojeto.cats.shared.security
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Service
import java.util.*
import javax.crypto.SecretKey

@Service
class JwtService {

    // Em produção isso vem de ENV ou vault
    private val secret: SecretKey = Keys.hmacShaKeyFor(
        "my-super-secret-key-my-super-secret-key-123456".toByteArray()
    )

    private val expirationMs: Long = 1000 * 60 * 60 // 1 hora

    fun generateToken(username: String, expirationMillis: Long): String {
        val now = Date()
        val expiry = Date(now.time + expirationMillis)

        return Jwts.builder()
            .subject(username)
            .issuedAt(now)
            .expiration(expiry)
            .signWith(getSignKey())
            .compact()
    }

    fun extractUsername(token: String): String {
        return Jwts.parser()
            .verifyWith(secret)
            .build()
            .parseSignedClaims(token)
            .payload
            .subject
    }

    fun isTokenValid(token: String): Boolean {
        return try {
            Jwts.parser()
                .verifyWith(secret)
                .build()
                .parseSignedClaims(token)
            true
        } catch (ex: Exception) {
            false
        }
    }

    fun generateAccessToken(username: String): String {
        return generateToken(username, 1000 * 60 * 15) // 15 min
    }

    fun generateRefreshToken(username: String): String {
        return generateToken(username, 1000L * 60 * 60 * 24 * 7) // 7 dias
    }
}