package com.example.roomhomework.presentation.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomhomework.R
import com.example.roomhomework.domain.model.Order
import com.example.roomhomework.presentation.deleteClickListner.OnOrderItemClickListener
import com.example.roomhomework.utils.orderToString
import kotlinx.android.synthetic.main.item_order.view.*

class OrdersViewHolder(itemView: View, private val clickListener: OnOrderItemClickListener) :
    RecyclerView.ViewHolder(itemView) {
    companion object {
        fun newInstance(view: ViewGroup, clickListener: OnOrderItemClickListener) =
            OrdersViewHolder(
                LayoutInflater.from(view.context).inflate(
                    R.layout.item_order, view, false
                ), clickListener
            )
    }

    fun bind(item: Order) {
        item.apply {
            itemView.townInfo.text = itemView.context.getString(R.string.towns, fromTown, toTown)
            itemView.dates.text = itemView.context.getString(
                R.string.dates,
                departmentTime.orderToString(),
                arriveTime.orderToString()
            )
            itemView.personInfo.text =
                itemView.context.getString(R.string.person_info, personName, password, age)
        }
        itemView.btnDelete.setOnClickListener {
            clickListener.onDeleteButtonClicked(item)
        }
    }
}