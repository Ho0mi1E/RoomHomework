package com.example.roomhomework.presentation.viewModel


import android.view.View
import androidx.appcompat.widget.SwitchCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomhomework.domain.interactor.OrdersInteractor
import com.example.roomhomework.domain.model.Order
import com.example.roomhomework.utils.Constants
import com.example.roomhomework.utils.showSnack
import com.example.roomhomework.utils.toDate

import kotlinx.coroutines.launch


class OrdersViewModel(private val interactor: OrdersInteractor) : ViewModel() {

    private val _orders = MutableLiveData<List<Order>>()
    val orders: LiveData<List<Order>> get() = _orders

    fun createOrder(
        fromTown: String,
        toTown: String,
        departmentTime: String,
        arriveTime: String,
        personName: String,
        password: String,
        age: String,
        view: View,
        messageEmpty: String,
        messageDate: String,
        messagePassword: String
    ) {
        if (validation(
                fromTown,
                toTown,
                departmentTime,
                arriveTime,
                personName,
                password,
                view,
                messageEmpty,
                messageDate,
                messagePassword
            )
        ) {
            viewModelScope.launch {
                interactor.saveOrder(
                    Order(
                        fromTown = fromTown,
                        toTown = toTown,
                        departmentTime = departmentTime.toDate(),
                        arriveTime = arriveTime.toDate(),
                        personName = personName,
                        password = password,
                        age = age
                    )
                )
            }
        }
    }

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

    private fun validation(
        fromTown: String,
        toTown: String,
        departmentTime: String,
        arriveTime: String,
        personName: String,
        password: String,
        view: View,
        messageEmpty: String,
        messageDate: String,
        messagePassword: String
    ): Boolean {
        var emptyFlag = false
        var dateFlag = false
        var mainFlag = false
        if (fromTown.isEmpty()
            || toTown.isEmpty()
            || departmentTime.isEmpty()
            || arriveTime.isEmpty()
            || password.isEmpty()
            || personName.isEmpty()
        ) {
            showSnack(messageEmpty, view)
        } else {
            emptyFlag = true
        }
        if (emptyFlag) {
            dateFlag =
                if (
                    departmentTime.length < Constants.LENGTH_PASSWORD
                    || arriveTime.length < Constants.LENGTH_PASSWORD
                ) {
                    showSnack(messageDate, view)
                    false
                } else {
                    true
                }
        }
        if (dateFlag) {
            var checkSymbol = false
            password.substring(2).forEach { char ->
                if (!char.isDigit()) {
                    checkSymbol = true
                }
            }

            val isPassportValid = password[0].isDigit()
                    || password[1].isDigit()
                    || checkSymbol ||
                    password.length < Constants.LENGTH_PASSWORD_DIGITS
            if (
                isPassportValid
            ) {
                showSnack(messagePassword, view)
            } else {
                mainFlag = true
            }
        }
        return mainFlag
    }

    fun viewSwitchType(
        switchCompat: SwitchCompat,
        child: String,
        adult: String
    ): String {
        return if (switchCompat.isChecked) {
            child
        } else {
            adult
        }
    }
}