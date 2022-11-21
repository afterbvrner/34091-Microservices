package com.itmo.microservices.demo.aggregates.logic

import com.itmo.microservices.demo.aggregates.api.OrderCreatedEvent
import java.util.UUID

fun OrderAggregateState.createOrder(id: UUID = UUID.randomUUID()): OrderCreatedEvent =
    OrderCreatedEvent(id)