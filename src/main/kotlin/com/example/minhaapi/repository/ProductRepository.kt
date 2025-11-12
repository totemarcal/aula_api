package com.example.minhaapi.repository


import com.example.minhaapi.model.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.transaction.annotation.Transactional


@Repository
interface ProductRepository : JpaRepository<Product, Long> {

    // Busca todos os produtos (SQL nativo)
    @Query(value = "SELECT * FROM products", nativeQuery = true)
    fun findAllProducts(): List<Product>

    // Busca um produto pelo nome
    @Query(value = "SELECT * FROM products WHERE name = :name", nativeQuery = true)
    fun findByName(@Param("name") name: String): Product?

    // Busca produtos com preço acima de um valor
    @Query(value = "SELECT * FROM products WHERE price > :price", nativeQuery = true)
    fun findProductsAbovePrice(@Param("price") price: Double): List<Product>

    // Atualiza a quantidade de um produto
    @Modifying
    @Transactional
    @Query(value = "UPDATE products SET quantity = :quantity WHERE id = :id", nativeQuery = true)
    fun updateQuantity(@Param("id") id: Long, @Param("quantity") quantity: Int)

    // Deleta produto pelo nome
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM products WHERE name = :name", nativeQuery = true)
    fun deleteByName(@Param("name") name: String)

}
