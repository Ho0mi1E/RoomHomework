package com.example.roomhomework

import android.app.Application

class OrdersApplication : Application() {
    companion object{
        var appComponent : AppComponent? = null
    }

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }
    private fun initDagger(){
       appComponent = DaggerAppComponent.builder().buildContext(this).build()

    }
}