package com.example.roomhomework.presintation.di

import com.example.roomhomework.presintation.viewModel.OrdersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel{OrdersViewModel(interactor = get())}
}