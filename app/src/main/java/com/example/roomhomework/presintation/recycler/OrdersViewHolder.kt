package com.example.roomhomework.presintation.recycler

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomhomework.R
import com.example.roomhomework.domain.model.Order
import com.example.roomhomework.presintation.deleteClickListner.DeleteClickListener
import com.example.roomhomework.presintation.fragments.DeleteDialogFragment
import com.example.roomhomework.utils.orderToString
import kotlinx.android.synthetic.main.item_order.view.*

class OrdersViewHolder(itemView: View, private val clickListener: DeleteClickListener) :
    RecyclerView.ViewHolder(itemView) {
    companion object {
        fun newInstance(view: ViewGroup, clickListener: DeleteClickListener) = OrdersViewHolder(
            LayoutInflater.from(view.context).inflate(
                R.layout.item_order, view, false
            ), clickListener
        )
    }

    @SuppressLint("SetTextI18n")
    fun bind(item: Order) {
        item.apply {
            itemView.townsInfo.text = "$townFrom - $townTo"
            itemView.dateInfo.text =
                "Вылет ${timeDepart.orderToString()}. Прибытие ${timeArrive.orderToString()}"
            itemView.personInfo.text =
                "Имя: $personName. Номер паспорта: $password. Тип билета: $typeOfPeople"
        }

        itemView.btnDelete.setOnClickListener {
            val dialog = DeleteDialogFragment(clickListener,item)
            dialog.show(clickListener.getSupport(),"ff")
        }
    }
}