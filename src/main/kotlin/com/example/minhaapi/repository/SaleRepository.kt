package com.example.minhaapi.repository


import com.example.minhaapi.model.Sale
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface SaleRepository : JpaRepository<Sale, Long> {

}
