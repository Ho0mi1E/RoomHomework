package com.example.roomhomework.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.roomhomework.domain.model.Order

sealed class BasicViewModel : ViewModel() {

    protected  val _orders = MutableLiveData<List<Order>>()
    val orders: LiveData<List<Order>> get() = _orders
}