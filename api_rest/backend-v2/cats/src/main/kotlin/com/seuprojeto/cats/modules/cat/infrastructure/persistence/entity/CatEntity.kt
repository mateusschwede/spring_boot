package com.seuprojeto.cats.modules.cat.infrastructure.persistence.entity
import jakarta.persistence.*

@Entity
@Table(name = "cats")
data class CatEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val adopted: Boolean
)