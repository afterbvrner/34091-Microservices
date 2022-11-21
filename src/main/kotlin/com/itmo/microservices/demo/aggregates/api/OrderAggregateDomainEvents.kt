package com.itmo.microservices.demo.aggregates.api


import com.itmo.microservices.demo.aggregates.api.ItemCreatedEvent.Companion.ITEM_CREATED_EVENT
import com.itmo.microservices.demo.aggregates.api.OrderCreatedEvent.Companion.ORDER_CREATED_EVENT
import ru.quipy.core.annotations.DomainEvent
import ru.quipy.domain.Event
import java.math.BigDecimal
import java.util.*

@DomainEvent(name = ITEM_CREATED_EVENT)
class ItemCreatedEvent(val itemName: String,
                       val itemCost: BigDecimal,
                       createdAt: Long = System.currentTimeMillis()
) : Event<OrderAggregate>(
    name = ITEM_CREATED_EVENT,
    createdAt = createdAt
) {

    companion object {
        const val ITEM_CREATED_EVENT = "ITEM_CREATED_EVENT"
    }
}

@DomainEvent(name = ORDER_CREATED_EVENT)
class OrderCreatedEvent(val orderId: UUID): Event<OrderAggregate>(
    name = ORDER_CREATED_EVENT,
) {

    companion object {
        const val ORDER_CREATED_EVENT = "ORDER_CREATED_EVENT"
    }
}