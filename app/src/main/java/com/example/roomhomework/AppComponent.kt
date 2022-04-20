package com.example.roomhomework

import android.content.Context
import com.example.roomhomework.data.di.DataModule
import com.example.roomhomework.data.di.RoomModule
import com.example.roomhomework.domain.di.DomainModule
import com.example.roomhomework.presentation.MainActivity
import com.example.roomhomework.presentation.di.ViewModelModule
import com.example.roomhomework.presentation.fragments.HistoryFragment
import com.example.roomhomework.presentation.fragments.RegistrationFragment
import dagger.BindsInstance
import dagger.Component

    @Component(modules = [DomainModule::class, DataModule::class,RoomModule::class,ViewModelModule::class])
    interface AppComponent {
        fun injectHistory(target: HistoryFragment)
        fun inject(target: RegistrationFragment)

        @Component.Builder
        interface Builder{

            @BindsInstance
            fun buildContext(context: Context) : Builder


            fun build() : AppComponent

        }
    }

