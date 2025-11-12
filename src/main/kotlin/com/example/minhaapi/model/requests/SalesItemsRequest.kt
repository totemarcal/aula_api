package com.example.minhaapi.model.requests

import java.math.BigDecimal

data class SaleItemRequest(
    val id: Int = 0,
    val product_id: Int,
    val quantity: Int,
    val unitPrice: BigDecimal,
    val subtotal: BigDecimal
)
