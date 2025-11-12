package com.example.minhaapi.model

import jakarta.persistence.Entity
import jakarta.persistence.Table

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table(name = "sales")
data class Sale(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    @Column(name = "customer_name", nullable = false, length = 100)
    val customerName: String,

    @Column(name = "sale_date", nullable = false)
    val saleDate: LocalDateTime = LocalDateTime.now(),

    @Column(name = "total_amount", nullable = false, precision = 10, scale = 2)
    val totalAmount: BigDecimal,

   /* @OneToMany(mappedBy = "sale", cascade = [CascadeType.ALL], fetch = FetchType.LAZY, orphanRemoval = true)
    val items: List<SaleItem> = emptyList()*/
)
