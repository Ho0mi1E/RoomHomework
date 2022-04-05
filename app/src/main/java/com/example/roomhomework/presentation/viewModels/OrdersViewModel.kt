package com.example.roomhomework.presentation.viewModels



import androidx.appcompat.widget.SwitchCompat
import androidx.lifecycle.viewModelScope
import com.example.roomhomework.domain.interactor.OrdersInteractor
import com.example.roomhomework.domain.model.Order
import com.example.roomhomework.utils.Constants
import com.example.roomhomework.utils.toDate
import kotlinx.coroutines.launch


class OrdersViewModel(private val interactor: OrdersInteractor) : BasicViewModel() {

    companion object {
        const val EMPTY_VALIDATION = 1
        const val DATE_VALIDATION = 2
        const val PASSWORD_VALIDATION = 3
    }

    fun createOrder(
        fromTown: String,
        toTown: String,
        departmentTime: String,
        arriveTime: String,
        personName: String,
        password: String,
        age: String,
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

    fun validation(
        fromTown: String,
        toTown: String,
        departmentTime: String,
        arriveTime: String,
        personName: String,
        password: String,
    ): Int {
        var emptyFlag = 0
        if (fromTown.isEmpty()
            || toTown.isEmpty()
            || departmentTime.isEmpty()
            || arriveTime.isEmpty()
            || password.isEmpty()
            || personName.isEmpty()
        ) {
            emptyFlag = EMPTY_VALIDATION
        }
        if (emptyFlag == 0
            && (departmentTime.length < Constants.LENGTH_PASSWORD
                    || arriveTime.length < Constants.LENGTH_PASSWORD)
        )
            emptyFlag = DATE_VALIDATION
        if (emptyFlag == 0) {
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
            if (isPassportValid)
                emptyFlag = PASSWORD_VALIDATION
        }
        return emptyFlag
    }

    fun viewSwitchType(
        switchCompat: SwitchCompat,
        child: String,
        adult: String
    ): String {
        return if (switchCompat.isChecked)
            child
        else
            adult
    }
}