package com.example.roomhomework.domain.model

import java.util.*

data class Order(
    val id: Int = 0,
    val fromTown: String,
    val toTown: String,
    val departmentTime: Date,
    val arriveTime: Date,
    val personName: String,
    val password: String,
    val age: String
)