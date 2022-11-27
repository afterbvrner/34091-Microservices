package com.itmo.microservices.demo.order.api.model

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import java.time.LocalDateTime

//for example
@JsonInclude(JsonInclude.Include.NON_NULL)
data class PaymentInformation @JsonCreator constructor(
    val time: LocalDateTime
)