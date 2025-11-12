package com.example.minhaapi.model.requests

import java.math.BigDecimal
import java.time.LocalDateTime

data class SaleRequest(
    val id: Int = 0,
    val customerName: String,
    val saleDate: LocalDateTime = LocalDateTime.now(),
    val totalAmount: BigDecimal,
    val items: List<SaleItemRequest> = emptyList()
)
