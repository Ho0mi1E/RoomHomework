package com.example.roomhomework.domain.interactor

import com.example.roomhomework.domain.OrdersRepository
import com.example.roomhomework.domain.model.Order
import com.example.roomhomework.domain.toDeleteOrderEntity
import com.example.roomhomework.domain.toOrder
import com.example.roomhomework.domain.toOrderEntity

class OrdersInteractorImpl(private val repository: OrdersRepository) : OrdersInteractor {
    override suspend fun getOrders(): List<Order> {
        return repository.getOrdersEntity().map { orderEntity ->
            orderEntity.toOrder()
        }
    }

    override suspend fun saveOrder(order: Order) {
        repository.saveOrderEntity(order.toOrderEntity())
    }

    override suspend fun deleteOrder(order: Order) {
        repository.deleteOrder(order.toDeleteOrderEntity())
    }
}