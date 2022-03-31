package com.example.roomhomework.domain.di

import com.example.roomhomework.domain.interactor.OrdersInteractor
import com.example.roomhomework.domain.interactor.OrdersInteractorImpl
import org.koin.dsl.module

val domainModule = module {
    single<OrdersInteractor> { OrdersInteractorImpl(repository = get()) }
}