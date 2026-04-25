package com.example.demo.controller

import com.example.demo.dto.ProductRequest
import com.example.demo.dto.ProductResponse
import com.example.demo.dto.PageResponse
import com.example.demo.service.ProductService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

@RestController
@RequestMapping("/api/v1/products")
class ProductController(
    private val productService: ProductService
) {

    // =========================
    // GET ALL
    // =========================
    @GetMapping
    fun getAllProducts(pageable: Pageable): ResponseEntity<PageResponse<ProductResponse>> =
        ResponseEntity.ok(productService.getAll(pageable))

    // =========================
    // GET BY ID
    // =========================
    @GetMapping("/{id}")
    fun getProductById(@PathVariable id: Long): ResponseEntity<ProductResponse> =
        ResponseEntity.ok(productService.getById(id))

    // =========================
    // CREATE
    // =========================
    @PostMapping
    fun createProduct(
        @Valid @RequestBody request: ProductRequest
    ): ResponseEntity<ProductResponse> =
        ResponseEntity.ok(productService.create(request))

    // =========================
    // UPDATE
    // =========================
    @PutMapping("/{id}")
    fun updateProduct(
        @PathVariable id: Long,
        @RequestBody request: ProductRequest
    ): ResponseEntity<ProductResponse> =
        ResponseEntity.ok(productService.update(id, request))

    // =========================
    // DELETE
    // =========================
    @DeleteMapping("/{id}")
    fun deleteProduct(@PathVariable id: Long): ResponseEntity<Void> {
        productService.delete(id)
        return ResponseEntity.noContent().build()
    }
}