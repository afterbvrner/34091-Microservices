package com.itmo.microservices.demo.aggregates.logic

import com.itmo.microservices.demo.aggregates.api.ItemCreatedEvent
import com.itmo.microservices.demo.aggregates.api.OrderAggregate
import com.itmo.microservices.demo.aggregates.api.OrderCreatedEvent
import ru.quipy.core.annotations.StateTransitionFunc
import ru.quipy.domain.AggregateState
import java.math.BigDecimal
import java.util.UUID

class OrderAggregateState : AggregateState<UUID, OrderAggregate> {
    private lateinit var orderId: UUID

    private var createdAt: Long = System.currentTimeMillis()

    private var updatedAt: Long = System.currentTimeMillis()

    private var items = mutableMapOf<UUID, Item>()

    override fun getId() = orderId

    @StateTransitionFunc
    fun itemCreatedApply(event: ItemCreatedEvent) {
        items[event.id] = Item(name = event.name, cost = event.itemCost)
        updatedAt = createdAt
    }

    @StateTransitionFunc
    fun orderCreatedApply(event: OrderCreatedEvent) {
        orderId = event.orderId
    }
}

data class Item(
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val cost: BigDecimal
)