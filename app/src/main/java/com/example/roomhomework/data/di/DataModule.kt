package com.example.roomhomework.data.di

import com.example.roomhomework.data.repository.OrdersRepositoryImpl
import com.example.roomhomework.data.storage.OrdersDao
import com.example.roomhomework.domain.OrdersRepository
import dagger.Module
import dagger.Provides


@Module
class DataModule {

    @Provides
    fun getRepository(dao: OrdersDao): OrdersRepository{
        return OrdersRepositoryImpl(dao)
    }
}