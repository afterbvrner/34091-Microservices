package com.itmo.microservices.demo.order.logic

import com.itmo.microservices.demo.order.api.OrderAggregate
import com.itmo.microservices.demo.order.api.enums.OrderStatus
import com.itmo.microservices.demo.order.api.events.OrderAddItemEvent
import com.itmo.microservices.demo.order.api.events.OrderBookEvent
import com.itmo.microservices.demo.order.api.events.OrderCreateEvent
import com.itmo.microservices.demo.order.api.events.OrderFillDeliveryEvent
import com.itmo.microservices.demo.order.api.model.PaymentLogRecordDto
import ru.quipy.bankDemo.accounts.api.AccountAggregate
import ru.quipy.core.annotations.StateTransitionFunc
import ru.quipy.domain.AggregateState
import java.util.UUID

class Order : AggregateState<UUID, OrderAggregate> {
    private lateinit var id: UUID
    private var timeCreated: Long = System.currentTimeMillis()
    private var deliveryDuration: Int? = null // ????
    private lateinit var status: OrderStatus

    var itemsMap: MutableMap<UUID, Int> = mutableMapOf()
    var paymentHistory: List<PaymentLogRecordDto> = listOf()

    override fun getId() = id

    fun createNewOrder(id: UUID = UUID.randomUUID()): OrderCreateEvent {
        return OrderCreateEvent(id);
    }

    fun putItem(itemId: UUID, amount: Int): OrderAddItemEvent {
        if (OrderStatus.COLLECTING !== status) {
            throw IllegalStateException("Order $id already is not collecting data. Current status $status")
        }
        return OrderAddItemEvent(itemId, amount);
    }

    fun bookOrder(): OrderBookEvent {
        if (OrderStatus.COLLECTING !== status) {
            throw IllegalStateException("Order $id already is not collecting data. Current status $status")
        }
        return OrderBookEvent(OrderStatus.BOOKED)
    }

    fun fillDeliveryTime(slot: Int): OrderFillDeliveryEvent {
        if (OrderStatus.COLLECTING !== status) {
            throw IllegalStateException("Order $id already is not collecting data. Current status $status")
        }
        return OrderFillDeliveryEvent(slot);
    }

    @StateTransitionFunc
    fun createNewOrder(event: OrderCreateEvent) {
        id = event.id;
        status = OrderStatus.COLLECTING
    }

    @StateTransitionFunc
    fun putItem(event: OrderAddItemEvent) {
        itemsMap[event.itemId] = event.amount;
    }

    @StateTransitionFunc
    fun updateStatus(event: OrderBookEvent) {
        status = event.status;
    }

    @StateTransitionFunc
    fun updateStatus(event: OrderFillDeliveryEvent) {
        deliveryDuration = event.slot;
    }
}