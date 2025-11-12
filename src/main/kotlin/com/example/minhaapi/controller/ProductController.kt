package com.example.minhaapi.controller


import com.example.minhaapi.model.Product
import com.example.minhaapi.service.ProductService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/products")
class ProductController(
    private val productService: ProductService
) {

    @GetMapping
    fun getAll(): List<Product> = productService.getAll()

    @GetMapping("/{name}")
    fun getByName(@PathVariable name: String): Product? = productService.getByName(name)

    @PostMapping
    fun create(@RequestBody product: Product): Product = productService.save(product)

    @PutMapping("/{id}/quantity/{quantity}")
    fun updateQuantity(
        @PathVariable id: Long,
        @PathVariable quantity: Int
    ): String {
        productService.updateQuantity(id, quantity)
        return "Quantidade atualizada!"
    }

    @DeleteMapping("/{name}")
    fun deleteByName(@PathVariable name: String): String {
        productService.delete(name)
        return "Produto removido!"
    }
}