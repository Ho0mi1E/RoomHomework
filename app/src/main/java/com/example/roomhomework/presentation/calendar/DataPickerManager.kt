package com.example.roomhomework.presentation.calendar

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import com.example.roomhomework.utils.orderToString
import com.google.android.material.textfield.TextInputEditText
import java.util.*

class DataPickerManager(private val context: Context) {

    fun openDataTimePicker(editView: TextInputEditText) {
        val calendar: Calendar = Calendar.getInstance()
        val datePickerDialog = DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.YEAR, year)
            timePickTime(editView, calendar, context)
        }

        DatePickerDialog(
            context,
            datePickerDialog,
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        ).show()
    }

    private fun timePickTime(editView: TextInputEditText, calendar: Calendar, context: Context) {
        val timePickerDialog = TimePickerDialog.OnTimeSetListener { _, hourOfDay, minute ->
            calendar.set(Calendar.HOUR_OF_DAY, hourOfDay)
            calendar.set(Calendar.MINUTE, minute)
            editView.setText(calendar.time.orderToString())
        }

        TimePickerDialog(
            context,
            timePickerDialog,
            calendar.get(Calendar.HOUR_OF_DAY),
            calendar.get(Calendar.MINUTE),
            false
        ).show()
    }
}