package com.example.roomhomework.data.storage.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "orders")
data class OrderEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    val fromTown: String,
    val toTown: String,
    val departureTime: String,
    val arrivalTime: String,
    val personName: String,
    val password: String,
    val age: String
)