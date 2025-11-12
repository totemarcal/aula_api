package com.example.minhaapi.service

import com.example.minhaapi.model.Sale
import com.example.minhaapi.model.requests.SaleRequest
import org.springframework.stereotype.Service

@Service
interface SaleService {
    fun save(sale: SaleRequest): Sale
}