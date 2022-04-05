package com.example.roomhomework.presentation.di

import com.example.roomhomework.presentation.viewModels.HistoryViewModel
import com.example.roomhomework.presentation.viewModels.OrdersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel{OrdersViewModel(interactor = get())}
    viewModel{HistoryViewModel(interactor = get())}
}