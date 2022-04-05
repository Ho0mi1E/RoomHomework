package com.example.roomhomework.data.repository

import com.example.roomhomework.data.storage.OrdersDao
import com.example.roomhomework.data.storage.entity.OrderEntity
import com.example.roomhomework.domain.OrdersRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class OrdersRepositoryImpl(private val orderDao: OrdersDao) : OrdersRepository {
    override suspend fun getOrdersEntity(): List<OrderEntity> {
        return withContext(Dispatchers.IO) {
            return@withContext orderDao.getAllOrders()
        }
    }

    override suspend fun saveOrderEntity(order: OrderEntity) {
        withContext(Dispatchers.IO) {
            orderDao.saveOrder(order)
        }
    }

    override suspend fun deleteOrder(order: OrderEntity) {
        withContext(Dispatchers.IO) {
            orderDao.deleteOrder(order)
        }
    }
}