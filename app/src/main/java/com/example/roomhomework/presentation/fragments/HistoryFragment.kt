package com.example.roomhomework.presentation.fragments


import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.roomhomework.R
import com.example.roomhomework.domain.model.Order
import com.example.roomhomework.presentation.deleteClickListner.OnOrderItemClickListener
import com.example.roomhomework.presentation.recycler.OrdersAdapter
import com.example.roomhomework.presentation.viewModels.HistoryViewModel
import kotlinx.android.synthetic.main.fragment_history.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HistoryFragment : Fragment(R.layout.fragment_history) {
    companion object {
        const val TAG = "History"
        fun newInstance() = HistoryFragment()
    }

    private val clickListener = object : OnOrderItemClickListener {
        override fun onDeleteButtonClicked(order: Order) {
            val builder = activity?.let { fragmentActivity ->
                AlertDialog.Builder(fragmentActivity)
                    .setTitle(getString(R.string.alert_title))
                    .setPositiveButton(getString(R.string.alert_yes)) { _, _ ->
                        viewModel.deleteOrder(order)
                        requireActivity()
                            .supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.container, newInstance(), TAG)
                            .commit()
                    }
                    .setNegativeButton(R.string.alert_no) { dialog, _ -> dialog.cancel() }
            }
            builder?.create()?.show()
        }
    }

    private val viewModel: HistoryViewModel by viewModel()
    private val adapter by lazy { OrdersAdapter(clickListener) }

    override fun onStart() {
        super.onStart()
        initObserves()
    }

    private fun initObserves() {
        viewModel.getOrders()
        viewModel.orders.observe(viewLifecycleOwner) { list ->
            adapter.submitOrders(list)
        }
        recycler.adapter = adapter
    }


}