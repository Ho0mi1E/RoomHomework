package com.example.roomhomework.utils

import android.annotation.SuppressLint
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import com.google.android.material.snackbar.Snackbar
import java.text.SimpleDateFormat
import java.util.*


fun FragmentActivity.openFragment(container: Int, tag: String, fragment: Fragment) {
    supportFragmentManager.beginTransaction()
        .replace(container, fragment, tag)
        .addToBackStack(tag)
        .commit()

}

fun ViewModel.showSnack(message: String, view: View) {
    Snackbar.make(view, message, Snackbar.LENGTH_LONG).show()
}


@SuppressLint("SimpleDateFormat")
fun String.toDate(): Date {
    return SimpleDateFormat("dd/MM/yy HH:mm", Locale.ENGLISH).parse(this)

}

@SuppressLint("SimpleDateFormat")
fun Date.orderToString(): String {
    return SimpleDateFormat("dd/MM/yy HH:mm", Locale.ENGLISH).format(this)
}