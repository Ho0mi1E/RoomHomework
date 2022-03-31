package com.example.roomhomework.domain.model


import java.time.LocalDateTime
import java.util.*


data class Order(
    val id: Int = 0,
    val townFrom: String,
    val townTo: String,
    val timeDepart: Date,
    val timeArrive: Date,
    val personName: String,
    val password: String,
    val typeOfPeople: String
)