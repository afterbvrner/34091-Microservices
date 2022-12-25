package com.itmo.microservices.demo.order.api.events

import com.itmo.microservices.demo.order.api.OrderAggregate
import ru.quipy.core.annotations.DomainEvent
import ru.quipy.domain.Event
import java.util.UUID

const val ORDER_ADD_ITEM = "ORDER_ADD_ITEM";

@DomainEvent(name = ORDER_ADD_ITEM)
data class OrderAddItemEvent(
    val itemId: UUID,
    val amount: Int,
) : Event<OrderAggregate>(name = ORDER_ADD_ITEM)