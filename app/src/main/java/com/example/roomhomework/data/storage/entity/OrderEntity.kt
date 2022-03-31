package com.example.roomhomework.data.storage.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "orders")
data class OrderEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    val townFrom: String,
    val townTo: String,
    val timeDepart: String,
    val timeArrive: String,
    val personName: String,
    val password: String,
    val typeOfPeople: String
)