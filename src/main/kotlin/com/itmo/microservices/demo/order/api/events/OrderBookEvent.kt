package com.itmo.microservices.demo.order.api.events

import com.itmo.microservices.demo.order.api.OrderAggregate
import com.itmo.microservices.demo.order.api.enums.OrderStatus
import ru.quipy.core.annotations.DomainEvent
import ru.quipy.domain.Event

const val ORDER_BOOK = "ORDER_BOOK";

@DomainEvent(name = ORDER_BOOK)
data class OrderBookEvent(
    val status: OrderStatus
) : Event<OrderAggregate>(name = ORDER_BOOK)