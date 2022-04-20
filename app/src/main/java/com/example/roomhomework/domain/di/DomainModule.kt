package com.example.roomhomework.domain.di

import com.example.roomhomework.domain.OrdersRepository
import com.example.roomhomework.domain.interactor.OrdersInteractor
import com.example.roomhomework.domain.interactor.OrdersInteractorImpl
import dagger.Module
import dagger.Provides


@Module
class DomainModule {

    @Provides
    fun getInteractor(repository: OrdersRepository) : OrdersInteractor{
        return OrdersInteractorImpl(repository)
    }

}

