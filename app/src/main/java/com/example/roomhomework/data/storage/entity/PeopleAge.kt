package com.example.roomhomework.data.storage.entity

import androidx.annotation.StringRes
import com.example.roomhomework.R

enum class PeopleAge(@StringRes val type:  Int) {
    ADULT(R.string.adult),
    CHILD(R.string.child)
}