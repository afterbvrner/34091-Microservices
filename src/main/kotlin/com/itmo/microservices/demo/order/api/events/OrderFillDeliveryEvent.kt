package com.itmo.microservices.demo.order.api.events

import com.itmo.microservices.demo.order.api.OrderAggregate
import ru.quipy.core.annotations.DomainEvent
import ru.quipy.domain.Event

const val ORDER_FILL_DELIVERY = "ORDER_FILL_DELIVERY";

@DomainEvent(name = ORDER_FILL_DELIVERY)
data class OrderFillDeliveryEvent(
    val slot: Int
) : Event<OrderAggregate>(name = ORDER_FILL_DELIVERY)