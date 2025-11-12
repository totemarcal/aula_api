package com.example.minhaapi.service

import com.example.minhaapi.model.Product
import org.springframework.stereotype.Service

@Service
interface ProductService {
    fun getAll(): List<Product>
    fun getByName(name: String): Product?
    fun save(product: Product): Product
    fun update(product: Product): String
    fun updateQuantity( id: Long, quantity: Int)
    fun delete(name: String): String
}