package com.example.roomhomework.presentation.viewModels


import androidx.lifecycle.viewModelScope
import com.example.roomhomework.domain.interactor.OrdersInteractor
import com.example.roomhomework.domain.model.Order
import kotlinx.coroutines.launch

class HistoryViewModel(private val interactor: OrdersInteractor) : BasicViewModel() {

    fun getOrders() {
        viewModelScope.launch {
            _orders.postValue(interactor.getOrders())
        }
    }

    fun deleteOrder(order: Order) {
        viewModelScope.launch {
            interactor.deleteOrder(order)
        }
    }
}