package com.example.roomhomework.presintation.fragments


import androidx.fragment.app.Fragment
import com.example.roomhomework.R
import com.example.roomhomework.data.storage.entity.TypeOfPeople
import com.example.roomhomework.domain.model.Order
import com.example.roomhomework.presintation.viewModel.OrdersViewModel
import com.example.roomhomework.utils.openFragment
import com.example.roomhomework.utils.showToast
import com.example.roomhomework.utils.toDate
import kotlinx.android.synthetic.main.fragment_registration.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegistrationFragment : Fragment(R.layout.fragment_registration) {
    companion object {
        const val TAG = "Registration"
        fun newInstance() = RegistrationFragment()
    }

    private val viewModel: OrdersViewModel by viewModel()

    override fun onStart() {
        super.onStart()
        createOrder()
        openHistoryFragment()
        viewSwitch.setOnClickListener {
            viewSwitch.showNext()
        }
    }

    private fun createOrder() {
        btnConfirm.setOnClickListener {
            if (validation()) {
                viewModel.createOrder(
                    Order(
                        townFrom = fromTown.text.toString(),
                        townTo = toTown.text.toString(),
                        timeDepart = departureTime.text.toString().toDate(),
                        timeArrive = arrivalTime.text.toString().toDate(),
                        personName = name.text.toString(),
                        password = password.text.toString(),
                        typeOfPeople = viewSwitchType()
                    )
                )
            }
        }
    }

    private fun openHistoryFragment() {
        btnHistory.setOnClickListener {
            requireActivity().openFragment(
                R.id.container,
                HistoryFragment.TAG,
                HistoryFragment.newInstance()
            )
        }
    }

    private fun validation(): Boolean {
        var emptyFlag = false
        var dateFlag = false
        var mainFlag = false
        if (fromTown.text.isEmpty() || toTown.text.isEmpty() || departureTime.text.isEmpty() || arrivalTime.text.isEmpty() || password.text.isEmpty() || name.text.isEmpty()) {
            showToast("Есть не заполненные поля")
        } else {
            emptyFlag = true
        }
        if (emptyFlag) {
            dateFlag = dateValidation()
        }
        if (dateFlag) {
            mainFlag = passwordValidation()
        }
        return mainFlag
    }

    private fun dateValidation(): Boolean {
        return if (departureTime.text.length < 14 || arrivalTime.text.length < 14) {
            showToast("Неккоректная дата")
            false
        } else {
            true
        }
    }
    private fun passwordValidation(): Boolean {
        var checkSymbol = false
        var flag = false
        password.text.toString().substring(2).forEach { char ->
            if (!char.isDigit()) {
                checkSymbol = true
            }
        }
        if (
            password.text.toString()[0].isDigit()
            || password.text.toString()[1].isDigit()
            || checkSymbol ||
            password.text.toString().length < 9) {
            showToast("Неккоректный номер паспорта")
        } else {
            flag = true
        }
        return flag
    }

    private fun viewSwitchType(): String {
        return if (viewSwitch.currentView == adult) {
            TypeOfPeople.ADULT.type
        } else {
            TypeOfPeople.CHILD.type
        }
    }
}