package com.example.roomhomework.presintation.deleteClickListner

import androidx.fragment.app.FragmentManager
import com.example.roomhomework.domain.model.Order
import java.text.FieldPosition

interface DeleteClickListener {
    fun clickListener(order: Order)
    fun getSupport(): FragmentManager
}