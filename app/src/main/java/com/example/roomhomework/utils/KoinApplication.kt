package com.example.roomhomework.utils

import android.app.Application
import com.example.roomhomework.data.di.daoModule
import com.example.roomhomework.data.di.dataModule
import com.example.roomhomework.domain.di.domainModule
import com.example.roomhomework.presintation.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class KoinApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@KoinApplication)
            modules(listOf(viewModelModule, domainModule, dataModule, daoModule))
        }

    }
}