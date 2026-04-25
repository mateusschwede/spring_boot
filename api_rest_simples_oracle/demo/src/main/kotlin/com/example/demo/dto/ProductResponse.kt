package com.example.demo.dto

data class ProductResponse(
    val id: Long,
    val name: String,
    val description: String,
    val price: Double
)