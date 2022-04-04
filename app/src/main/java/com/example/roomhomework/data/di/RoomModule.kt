package com.example.roomhomework.data.di

import androidx.room.Room
import com.example.roomhomework.data.storage.AppDataBase
import com.example.roomhomework.data.storage.OrdersDao
import org.koin.dsl.module

val roomModule = module {
    single<AppDataBase> {
        Room.databaseBuilder(
            get(),
            AppDataBase::class.java,
            "orders"
        ).build()
    }
    single<OrdersDao> { get<AppDataBase>().getOrderDao() }
}