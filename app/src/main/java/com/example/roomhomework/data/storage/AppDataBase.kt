package com.example.roomhomework.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.roomhomework.data.storage.entity.OrderEntity

@Database(entities = [OrderEntity::class], version = AppDataBase.VERSION)
abstract class AppDataBase : RoomDatabase() {
    companion object {
        const val VERSION = 1
    }

    abstract fun getOrderDao(): OrdersDao
}