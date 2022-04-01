package com.example.roomhomework.presintation.fragments

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.roomhomework.domain.model.Order
import com.example.roomhomework.presintation.deleteClickListner.DeleteClickListener

class DeleteDialogFragment(private val clickListener: DeleteClickListener, val order: Order) :
    DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let { fragmentActivity ->
            val builder = AlertDialog.Builder(fragmentActivity)
            builder
                .setTitle("Вы уверены что хотите удалить?")
                .setPositiveButton("Да") { _, _ ->
                    clickListener.clickListener(order)
                }
                .setNegativeButton("Нет") { dialog, _ -> dialog.cancel() }
            builder.create()

        } ?: throw IllegalStateException("Activity cannot be null")
    }
}
