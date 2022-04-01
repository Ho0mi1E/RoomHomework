package com.example.roomhomework.utils

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import java.text.SimpleDateFormat
import java.util.*


fun FragmentActivity.openFragment(container: Int, tag: String, fragment: Fragment) {
    supportFragmentManager.beginTransaction()
        .replace(container, fragment, tag)
        .addToBackStack(tag)
        .commit()

}

fun Fragment.showToast(message: String) {
    Toast.makeText(this.requireContext(), message, Toast.LENGTH_LONG).show()
}


@SuppressLint("SimpleDateFormat")
fun String.toDate(): Date {
    return SimpleDateFormat("dd MM yy HH mm", Locale.ENGLISH).parse(this)

}

@SuppressLint("SimpleDateFormat")
fun Date.orderToString(): String {
    return SimpleDateFormat("dd MM yy HH mm", Locale.ENGLISH).format(this)
}