package com.example.roomhomework.presentation.fragments


import androidx.fragment.app.Fragment
import com.example.roomhomework.R
import com.example.roomhomework.data.storage.entity.PeopleAge
import com.example.roomhomework.presentation.viewModel.OrdersViewModel
import com.example.roomhomework.utils.openFragment
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
            val type =
                viewModel.viewSwitchType(
                    viewSwitch,
                    getString(PeopleAge.CHILD.type),
                    getString(PeopleAge.ADULT.type))
            viewModel.createOrder(
                fromTown = fromTown.text.toString(),
                toTown = toTown.text.toString(),
                departmentTime = departureTime.text.toString(),
                arriveTime = arrivalTime.text.toString(),
                personName = name.text.toString(),
                password = password.text.toString(),
                age = type,
                view = requireView(),
                messageEmpty = getString(R.string.snack_empty),
                messageDate = getString(R.string.snack_date),
                messagePassword = getString(R.string.snack_password)

            )
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