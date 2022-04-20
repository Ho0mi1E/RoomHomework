package com.example.roomhomework.presentation.di

import com.example.roomhomework.domain.interactor.OrdersInteractor
import com.example.roomhomework.presentation.viewModels.HistoryViewModel
import com.example.roomhomework.presentation.viewModels.OrdersViewModel
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule{
    @Provides
    fun getHistoryViewModel(interactor: OrdersInteractor): HistoryViewModel{
        return HistoryViewModel(interactor)
    }

    fun getOrdersViewModel(interactor: OrdersInteractor): OrdersViewModel {
        return OrdersViewModel(interactor)
    }
}