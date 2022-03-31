package com.example.roomhomework.presintation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.roomhomework.R
import com.example.roomhomework.presintation.fragments.RegistrationFragment
import com.example.roomhomework.utils.openFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        openFragment(R.id.container,RegistrationFragment.TAG,RegistrationFragment.newInstance())
    }



}