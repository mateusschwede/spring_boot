package com.seuprojeto.cats.modules.cat.domain.model

class Cat(
    val id: Long? = null,
    var name: String,
    var adopted: Boolean = false
) {

    init {
        require(name.isNotBlank()) {
            "Nome do gato não pode ser vazio"
        }
    }

    fun adopt() {
        if (adopted) {
            throw IllegalStateException("Gato adotado")
        }
        adopted = true
    }

    fun unadopt() {
        if (!adopted) {
            throw IllegalStateException("Gato não foi adotado")
        }
        adopted = false
    }

    fun updateName(newName: String) {
        require(newName.isNotBlank()) {
            "Nome do gato não pode ser vazio"
        }
        this.name = newName
    }
}