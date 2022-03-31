package com.example.roomhomework.domain

import com.example.roomhomework.data.storage.entity.OrderEntity
import com.example.roomhomework.domain.model.Order
import com.example.roomhomework.utils.orderToString
import com.example.roomhomework.utils.toDate
import java.sql.Date
import java.text.DateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

fun OrderEntity.toOrder() = Order(id,townFrom,townTo,timeDepart.toDate(),timeArrive.toDate(),personName,password, typeOfPeople)
fun Order.toOrderEntity() = OrderEntity(
    townFrom = townFrom,
    townTo =  townTo,
    timeDepart = timeDepart.orderToString(),
    timeArrive = timeArrive.orderToString(),
    personName = personName,
    password = password,
    typeOfPeople = typeOfPeople)


fun Order.toDeleteOrderEntity() = OrderEntity(
    id = id,
    townFrom = townFrom,
    townTo =  townTo,
    timeDepart = timeDepart.orderToString(),
    timeArrive = timeArrive.orderToString(),
    personName = personName,
    password = password,
    typeOfPeople = typeOfPeople)

