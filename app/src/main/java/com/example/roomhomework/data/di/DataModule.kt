package com.example.roomhomework.data.di

import com.example.roomhomework.data.repository.OrdersRepositoryImpl
import com.example.roomhomework.domain.OrdersRepository
import org.koin.dsl.module

val dataModule = module {
    single<OrdersRepository> { OrdersRepositoryImpl(get()) }
}