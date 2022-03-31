package com.example.roomhomework.domain

import com.example.roomhomework.data.storage.entity.OrderEntity

interface OrdersRepository {
    suspend fun getOrderEntity() : List<OrderEntity>

    suspend fun putOrder(order: OrderEntity)

    suspend fun deleteOrder(order: OrderEntity)
}