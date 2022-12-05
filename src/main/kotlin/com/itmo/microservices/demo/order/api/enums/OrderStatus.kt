package com.itmo.microservices.demo.order.api.enums

enum class OrderStatus(val dbKey: String) {
    COLLECTING("CL"),
    DISCARD("DS"),
    BOOKED("BK"),
    PAID("PD"),
    SHIPPING("SP"),
    REFUND("RF"),
    COMPLETED("CL")
}