package com.itmo.microservices.demo.order.api.enums

enum class PaymentStatus(dbKey: String)  {
    FAILED("FL"),
    SUCCESS("SC")
}