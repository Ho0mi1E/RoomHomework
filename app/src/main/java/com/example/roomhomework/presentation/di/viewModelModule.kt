package com.example.roomhomework.presentation.di

import com.example.roomhomework.presentation.viewModel.OrdersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel{OrdersViewModel(interactor = get())}
}