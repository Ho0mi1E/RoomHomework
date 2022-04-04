package com.example.roomhomework.domain

import com.example.roomhomework.data.storage.entity.OrderEntity
import com.example.roomhomework.domain.model.Order
import com.example.roomhomework.utils.orderToString
import com.example.roomhomework.utils.toDate

fun OrderEntity.toOrder() = Order(
    id,
    fromTown,
    toTown,
    departureTime.toDate(),
    arrivalTime.toDate(),
    personName,
    password,
    age
)

fun Order.toOrderEntity() = OrderEntity(
    fromTown = fromTown,
    toTown = toTown,
    departureTime = departmentTime.orderToString(),
    arrivalTime = arriveTime.orderToString(),
    personName = personName,
    password = password,
    age = age
)

fun Order.toDeleteOrderEntity() = OrderEntity(
    id = id,
    fromTown = fromTown,
    toTown = toTown,
    departureTime = departmentTime.orderToString(),
    arrivalTime = arriveTime.orderToString(),
    personName = personName,
    password = password,
    age = age
)

