package com.example.minhaapi.repository


import com.example.minhaapi.model.SaleItem
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface SaleItemRepository : JpaRepository<SaleItem, Long> {

}
