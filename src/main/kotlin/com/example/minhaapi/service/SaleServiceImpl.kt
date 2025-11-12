package com.example.minhaapi.service


import com.example.minhaapi.model.Sale
import com.example.minhaapi.model.SaleItem
import com.example.minhaapi.model.requests.SaleRequest
import com.example.minhaapi.repository.ProductRepository
import com.example.minhaapi.repository.SaleItemRepository
import com.example.minhaapi.repository.SaleRepository
import org.springframework.stereotype.Service


@Service
class SaleServiceImpl(
    val saleRepository: SaleRepository,
    val saleItemRepository: SaleItemRepository,
    val productRepository: ProductRepository
) : SaleService {
    override fun save(saleRequest: SaleRequest) : Sale {
        var sale = Sale(
            id = saleRequest.id,
            customerName = saleRequest.customerName,
            saleDate = saleRequest.saleDate,
            totalAmount = saleRequest.totalAmount
        )
        var result = saleRepository.save(sale)
        saleRequest.items.forEach { item ->
            var saleItems = SaleItem(
                sale = result,
                quantity = item.quantity,
                subtotal = item.subtotal,
                unitPrice = item.unitPrice,
                product_id = item.product_id
            )
            if (productRepository.existsById(item.product_id.toLong())) {
                saleItemRepository.save(saleItems)
            }
        }
        return result
    }
}