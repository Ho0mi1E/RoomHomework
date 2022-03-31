package com.example.roomhomework.presintation.fragments


import androidx.fragment.app.Fragment
import com.example.roomhomework.R
import com.example.roomhomework.data.storage.entity.TypeOfPeople
import com.example.roomhomework.domain.model.Order
import com.example.roomhomework.presintation.viewModel.OrdersViewModel
import com.example.roomhomework.utils.openFragment
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
            viewModel.createOrder(
                Order(
                    fromTown.text.toString(),
                    toTown.text.toString(),
                    departureTime.text.toString().toDate(),
                    arrivalTime.text.toString().toDate(),
                    name.text.toString(),
                    password.text.toString(),
                    viewSwitchType()
                )
            )
        }
    }

    private fun viewSwitchType(): String {
        return if (viewSwitch.currentView == adult) {
            TypeOfPeople.ADULT.name
        } else {
            TypeOfPeople.CHILD.name
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