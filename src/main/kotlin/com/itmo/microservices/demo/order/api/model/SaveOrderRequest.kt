package com.itmo.microservices.demo.order.api.model

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude

//for example
@JsonInclude(JsonInclude.Include.NON_NULL)
data class SaveOrderRequest @JsonCreator constructor(
    val id: Long? = null,
    val userId: Long,
    val items: List<Item> = emptyList(),
)