package com.example.roomhomework.domain

import com.example.roomhomework.data.storage.entity.OrderEntity

interface OrdersRepository {
    suspend fun getOrdersEntity() : List<OrderEntity>

    suspend fun saveOrderEntity(order: OrderEntity)

    suspend fun deleteOrder(order: OrderEntity)
}