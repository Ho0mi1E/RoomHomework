package com.example.roomhomework.presentation.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.roomhomework.R
import com.example.roomhomework.databinding.ItemOrderBinding
import com.example.roomhomework.domain.model.Order
import com.example.roomhomework.presentation.deleteClickListner.OnOrderItemClickListener
import com.example.roomhomework.utils.orderToString

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

    private val binding: ItemOrderBinding by viewBinding()

    fun bind(item: Order) {
        item.apply {
            binding.townInfo.text = itemView.context.getString(R.string.towns, fromTown, toTown)
            binding.dates.text = itemView.context.getString(
                R.string.dates,
                departmentTime.orderToString(),
                arriveTime.orderToString()
            )
            binding.personInfo.text =
                itemView.context.getString(R.string.person_info, personName, password, age)
        }
        binding.btnDelete.setOnClickListener {
            clickListener.onDeleteButtonClicked(item)
        }
    }
}