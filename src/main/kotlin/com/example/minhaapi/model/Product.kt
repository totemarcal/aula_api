package com.example.minhaapi.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal
import java.time.LocalDateTime


@Entity
@Table(name = "products")
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val name: String,

    val description: String? = null,

    @Column(nullable = false)
    val price: BigDecimal,

    @Column(nullable = false)
    val quantity: Int,

    @Column(name = "created_at")
    val createdAt: LocalDateTime = LocalDateTime.now()
)
