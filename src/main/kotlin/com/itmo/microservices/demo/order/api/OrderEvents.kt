package com.itmo.microservices.demo.order.api

import com.itmo.microservices.demo.order.api.enums.OrderStatus
import ru.quipy.core.annotations.DomainEvent
import ru.quipy.domain.Event
import java.util.UUID

const val ORDER_CREATE = "ORDER_CREATE";
const val ORDER_GET = "ORDER_GET";
const val ORDER_ADD_ITEM = "ORDER_ADD_ITEM";
const val ORDER_BOOK = "ORDER_BOOK";
const val ORDER_FILL_DELIVERY = "ORDER_FILL_DELIVERY";

class OrderEvents {
    @DomainEvent(name = ORDER_CREATE)
    data class OrderCreateEvent(
        val orderId: UUID
    ) : Event<OrderAggregate>(name = ORDER_CREATE)

    @DomainEvent(name = ORDER_ADD_ITEM)
    data class OrderAddItemEvent(
        val itemId: UUID,
        val amount: Int,
    ) : Event<OrderAggregate>(name = ORDER_ADD_ITEM)

    @DomainEvent(name = ORDER_BOOK)
    data class OrderBookEvent(
        val status: OrderStatus
    ) : Event<OrderAggregate>(name = ORDER_BOOK)

    @DomainEvent(name = ORDER_FILL_DELIVERY)
    data class OrderFillDeliveryEvent(
        val slot: Int
    ) : Event<OrderAggregate>(name = ORDER_FILL_DELIVERY)
}