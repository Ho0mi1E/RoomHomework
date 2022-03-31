package com.example.roomhomework.domain.interactor

import com.example.roomhomework.domain.OrdersRepository
import com.example.roomhomework.domain.model.Order
import com.example.roomhomework.domain.toDeleteOrderEntity
import com.example.roomhomework.domain.toOrder
import com.example.roomhomework.domain.toOrderEntity

class OrdersInteractorImpl(private val repository: OrdersRepository) : OrdersInteractor {
    override suspend fun getOrder(): List<Order> {
        return repository.getOrderEntity().map { orderEntity ->
            orderEntity.toOrder()
        }
    }

    override suspend fun putOrder(order: Order) {
        repository.putOrder(order.toOrderEntity())
    }

    override suspend fun deleteOrder(order: Order) {
        repository.deleteOrder(order.toDeleteOrderEntity())
    }
}