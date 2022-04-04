package com.example.roomhomework.data.storage

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.roomhomework.data.storage.entity.OrderEntity

@Dao
interface OrdersDao {

    @Query("SELECT * FROM orders")
    suspend fun getAllOrders(): List<OrderEntity>

    @Insert
    suspend fun saveOrder(order: OrderEntity)

    @Delete
    suspend fun deleteOrder(order: OrderEntity)

}