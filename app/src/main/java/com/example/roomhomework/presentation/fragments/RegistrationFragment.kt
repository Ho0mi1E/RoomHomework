package com.example.roomhomework.presentation.fragments


import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.roomhomework.OrdersApplication
import com.example.roomhomework.R
import com.example.roomhomework.data.storage.entity.PeopleAge
import com.example.roomhomework.databinding.FragmentRegistrationBinding
import com.example.roomhomework.presentation.calendar.DataPickerManager
import com.example.roomhomework.presentation.viewModels.OrdersViewModel
import com.example.roomhomework.utils.openFragment
import com.example.roomhomework.utils.showSnack
import kotlinx.android.synthetic.main.fragment_registration.*
import javax.inject.Inject

class RegistrationFragment : Fragment(R.layout.fragment_registration) {
    companion object {
        const val TAG = "Registration"
        fun newInstance() = RegistrationFragment()
    }

    @Inject
    lateinit var viewModel: OrdersViewModel

    private val binding: FragmentRegistrationBinding by viewBinding()

    override fun onStart() {
        super.onStart()
        OrdersApplication.appComponent?.inject(this)
        createOrder()
        openHistoryFragment()

    }

    private fun createOrder() {
        val calendar = DataPickerManager(requireContext())
        textInputLayout3.setOnClickListener {
            calendar.openDataTimePicker(departureTime)
        }
        textInputLayout4.setOnClickListener { calendar.openDataTimePicker(arrivalTime) }
        btnConfirm.setOnClickListener {
            val fromTown = binding.fromTown.text.toString()
            val toTown = binding.toTown.text.toString()
            val departmentTime = binding.departureTime.text.toString()
            val arriveTime = binding.arrivalTime.text.toString()
            val personName = binding.name.text.toString()
            val password = binding.password.text.toString()
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