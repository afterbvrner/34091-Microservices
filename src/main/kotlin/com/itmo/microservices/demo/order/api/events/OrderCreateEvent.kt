package com.itmo.microservices.demo.order.api.events

import com.itmo.microservices.demo.order.api.OrderAggregate
import ru.quipy.core.annotations.DomainEvent
import ru.quipy.domain.Event
import java.util.UUID

const val ORDER_CREATE = "ORDER_CREATE";

@DomainEvent(name = ORDER_CREATE)
data class OrderCreateEvent(
    val orderId: UUID
    ) : Event<OrderAggregate>(name = ORDER_CREATE)