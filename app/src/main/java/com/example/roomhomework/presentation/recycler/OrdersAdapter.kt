package com.example.roomhomework.presentation.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomhomework.domain.model.Order
import com.example.roomhomework.presentation.deleteClickListner.OnOrderItemClickListener

class OrdersAdapter(private val clickListener: OnOrderItemClickListener) :
    RecyclerView.Adapter<OrdersViewHolder>() {

    var orders = listOf<Order>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrdersViewHolder {
        return OrdersViewHolder.newInstance(parent, clickListener)
    }

    override fun onBindViewHolder(holder: OrdersViewHolder, position: Int) {
        holder.bind(orders[position])
    }

    override fun getItemCount(): Int {
        return orders.size
    }

    fun submitOrders(list: List<Order>) {
        orders = list
        notifyDataSetChanged()
    }
}