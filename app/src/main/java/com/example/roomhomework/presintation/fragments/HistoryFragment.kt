package com.example.roomhomework.presintation.fragments


import androidx.fragment.app.Fragment
import com.example.roomhomework.R
import com.example.roomhomework.domain.model.Order
import com.example.roomhomework.presintation.deleteClickListner.DeleteClickListener
import com.example.roomhomework.presintation.recycler.OrdersAdapter
import com.example.roomhomework.presintation.viewModel.OrdersViewModel
import com.example.roomhomework.utils.openFragment
import kotlinx.android.synthetic.main.fragment_history.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HistoryFragment : Fragment(R.layout.fragment_history) {
    companion object {
        const val TAG = "History"
        fun newInstance() = HistoryFragment()
    }

    private val clickListener = object : DeleteClickListener {
        override fun clickListener(order: Order) {
            viewModel.deleteOrder(order)
            viewModel.getOrders()
            requireActivity().supportFragmentManager.beginTransaction().replace(
                R.id.container,
                newInstance(), TAG
            ).commit()
        }
    }
    private val viewModel: OrdersViewModel by viewModel()
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