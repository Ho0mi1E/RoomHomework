package com.example.roomhomework.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.roomhomework.R
import com.example.roomhomework.databinding.ActivityMainBinding
import com.example.roomhomework.presentation.fragments.RegistrationFragment
import com.example.roomhomework.utils.openFragment

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by viewBinding()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        openFragment(R.id.container, RegistrationFragment.TAG, RegistrationFragment.newInstance())
    }
}