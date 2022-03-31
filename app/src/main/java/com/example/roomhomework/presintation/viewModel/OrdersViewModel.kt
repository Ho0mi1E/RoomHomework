package com.example.roomhomework.presintation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomhomework.domain.interactor.OrdersInteractor
import com.example.roomhomework.domain.model.Order
import kotlinx.coroutines.launch

class OrdersViewModel(private val interactor: OrdersInteractor) : ViewModel() {


    private val _orders = MutableLiveData<List<Order>>()
    val orders: LiveData<List<Order>> get() = _orders


    fun createOrder(order: Order) {
        viewModelScope.launch {
            interactor.putOrder(order)
        }
    }

    fun getOrders() {
        viewModelScope.launch {
            _orders.postValue(interactor.getOrder())
        }
    }

    fun deleteOrder(order: Order) {
        viewModelScope.launch {
            interactor.deleteOrder(order)
        }
    }
}