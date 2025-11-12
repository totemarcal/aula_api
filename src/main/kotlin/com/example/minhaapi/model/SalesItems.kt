package com.example.minhaapi.model

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "sales_items")
data class SaleItem(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sale_id", nullable = false)
    val sale: Sale,

    @Column(nullable = false)
    val product_id: Int,

    @Column(nullable = false)
    val quantity: Int,

    @Column(name = "unit_price", nullable = false, precision = 10, scale = 2)
    val unitPrice: BigDecimal,

    @Column(nullable = false, precision = 10, scale = 2)
    val subtotal: BigDecimal
)
