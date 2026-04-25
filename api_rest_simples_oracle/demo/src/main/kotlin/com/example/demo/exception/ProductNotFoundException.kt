package com.example.demo.exception

class ProductNotFoundException(id: Long) :
    RuntimeException("Product not found with id: $id")