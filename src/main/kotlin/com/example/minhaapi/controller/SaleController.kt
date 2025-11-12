package com.example.minhaapi.controller



import com.example.minhaapi.model.Sale
import com.example.minhaapi.model.requests.SaleRequest
import com.example.minhaapi.service.SaleService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/sale")
class SaleController(
    private val saleService: SaleService
) {

    @PostMapping
    fun create(@RequestBody sale: SaleRequest): Sale = saleService.save(sale)

}