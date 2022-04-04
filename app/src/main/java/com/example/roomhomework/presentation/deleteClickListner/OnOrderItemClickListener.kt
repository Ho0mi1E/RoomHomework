package com.example.roomhomework.presentation.deleteClickListner


import com.example.roomhomework.domain.model.Order

interface OnOrderItemClickListener {
    fun onDeleteButtonClicked(order: Order)
}