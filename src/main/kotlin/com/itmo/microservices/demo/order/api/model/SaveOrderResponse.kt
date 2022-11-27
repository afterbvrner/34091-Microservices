package com.itmo.microservices.demo.order.api.model

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
class SaveOrderResponse @JsonCreator constructor(
    val id: Long,
    val userId: Long,
    val items: List<Item>,
)