package com.example.roomhomework.domain.interactor

import com.example.roomhomework.data.storage.entity.OrderEntity
import com.example.roomhomework.domain.model.Order

interface OrdersInteractor {
    suspend fun getOrders(): List<Order>

    suspend fun saveOrder(order: Order)

    suspend fun deleteOrder(order: Order)
}