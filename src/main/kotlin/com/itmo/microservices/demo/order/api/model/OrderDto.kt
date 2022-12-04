package com.itmo.microservices.demo.order.api.model

import com.fasterxml.jackson.annotation.JsonInclude
import com.itmo.microservices.demo.order.api.enums.OrderStatus
import java.util.*

@JsonInclude(JsonInclude.Include.NON_NULL)
data class OrderDto(
    var id: UUID = UUID.randomUUID(),
    var timeCreated: Long,
    var status: OrderStatus,
    var itemsMap: Map<UUID, Int>,
    var deliveryDuration: Int? = null,
    var paymentHistory: List<PaymentLogRecordDto>
)