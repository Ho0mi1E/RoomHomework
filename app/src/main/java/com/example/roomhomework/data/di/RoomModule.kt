package com.example.roomhomework.data.di

import android.content.Context
import androidx.room.Room
import com.example.roomhomework.data.storage.AppDataBase
import com.example.roomhomework.data.storage.OrdersDao
import dagger.Module
import dagger.Provides

@Module
class RoomModule {

    @Provides
    fun getDataBase(context:Context): AppDataBase {
        return Room.databaseBuilder(
            context,
            AppDataBase::class.java,
            "orders"
        ).build()
    }

    @Provides
    fun getDao(appDataBase: AppDataBase): OrdersDao {
        return appDataBase.getOrderDao()
    }
}