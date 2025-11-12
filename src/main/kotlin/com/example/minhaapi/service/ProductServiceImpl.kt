package com.example.minhaapi.service


import com.example.minhaapi.model.Product
import com.example.minhaapi.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductServiceImpl(val productRepository: ProductRepository) : ProductService {

    override fun getAll(): List<Product> = productRepository.findAll()

    override fun getByName(name: String): Product? = productRepository.findByName(name)

    override fun save(product: Product): Product = productRepository.save(product)

    override fun update(product: Product): String {
        if (!productRepository.existsById(product.id))
            return "Produto não existe na base de dados"

        productRepository.save(product)

        return "Produto id ${product.id} alterado com sucesso"
    }

    override fun updateQuantity(id: Long, quantity: Int) = productRepository.updateQuantity(id, quantity)

    override fun delete(name: String): String {
        /*if (!productRepository.existsById(id))
            return "Produto não existe na base de dados"
*/
        productRepository.deleteByName(name)

        return "Produto removido com sucesso!"
    }
}