package com.example.roomhomework.presentation.fragments


import androidx.fragment.app.Fragment
import com.example.roomhomework.R
import com.example.roomhomework.data.storage.entity.PeopleAge
import com.example.roomhomework.presentation.viewModels.OrdersViewModel
import com.example.roomhomework.utils.openFragment
import com.example.roomhomework.utils.showSnack
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

    }

    private fun createOrder() {
        btnConfirm.setOnClickListener {
            val fromTown = fromTown.text.toString()
            val toTown = toTown.text.toString()
            val departmentTime = departureTime.text.toString()
            val arriveTime = arrivalTime.text.toString()
            val personName = name.text.toString()
            val password = password.text.toString()
            when (viewModel.validation(
                fromTown,
                toTown,
                departmentTime,
                arriveTime,
                personName,
                password
            )) {
                OrdersViewModel.EMPTY_VALIDATION -> showSnack(getString(R.string.snack_empty))
                OrdersViewModel.DATE_VALIDATION -> showSnack(getString(R.string.snack_date))
                OrdersViewModel.PASSWORD_VALIDATION -> showSnack(getString(R.string.snack_password))
                else -> {
                    val type =
                        viewModel.viewSwitchType(
                            viewSwitch,
                            getString(PeopleAge.CHILD.type),
                            getString(PeopleAge.ADULT.type)
                        )
                    viewModel.createOrder(
                        fromTown,
                        toTown,
                        departmentTime,
                        arriveTime,
                        personName,
                        password,
                        type
                    )
                }
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
}