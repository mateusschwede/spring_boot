package com.example.demo.service

import com.example.demo.dto.ProductRequest
import com.example.demo.dto.ProductResponse
import com.example.demo.dto.PageResponse
import com.example.demo.entity.Product
import com.example.demo.repository.ProductRepository
import org.springframework.stereotype.Service
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import com.example.demo.exception.ProductNotFoundException


@Service
class ProductService(
    private val productRepository: ProductRepository
) {

    // =========================
    // MAPPERS (isolados e limpos)
    // =========================

    private fun toResponse(product: Product): ProductResponse =
        ProductResponse(
            id = product.id!!,
            name = product.name,
            description = product.description,
            price = product.price
        )

    private fun toEntity(request: ProductRequest): Product =
        Product(
            name = request.name,
            description = request.description,
            price = request.price
        )

    // =========================
    // BUSINESS RULES
    // =========================

    fun getAll(pageable: Pageable): PageResponse<ProductResponse> {
        val page = productRepository.findAll(pageable)

        return PageResponse(
            content = page.content.map(::toResponse),
            page = page.number,
            size = page.size,
            totalElements = page.totalElements,
            totalPages = page.totalPages,
            isLast = page.isLast
        )
    }

    fun getById(id: Long): ProductResponse =
        productRepository.findById(id)
            .orElseThrow { ProductNotFoundException(id) }
            .let(::toResponse)

    fun create(request: ProductRequest): ProductResponse {
        val product = toEntity(request)
        return productRepository.save(product)
            .let(::toResponse)
    }

    fun update(id: Long, request: ProductRequest): ProductResponse {
        val product = productRepository.findById(id)
            .orElseThrow { ProductNotFoundException(id) }

        val updated = product.copy(
            name = request.name,
            description = request.description,
            price = request.price
        )

        return productRepository.save(updated)
            .let(::toResponse)
    }

    fun delete(id: Long) {
        if (!productRepository.existsById(id)) {
            throw ProductNotFoundException(id)
        }
        productRepository.deleteById(id)
    }
}