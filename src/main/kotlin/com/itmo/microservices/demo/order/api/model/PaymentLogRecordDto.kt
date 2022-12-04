package com.itmo.microservices.demo.order.api.model

import com.fasterxml.jackson.annotation.JsonInclude
import com.itmo.microservices.demo.order.api.enums.PaymentStatus
import java.util.*

@JsonInclude(JsonInclude.Include.NON_NULL)
data class PaymentLogRecordDto(
    val timestamp: Long,
    val status: PaymentStatus,
    val amount: Int,
    val transactionId: UUID
)