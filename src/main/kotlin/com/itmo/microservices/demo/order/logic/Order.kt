package com.itmo.microservices.demo.order.logic

import com.itmo.microservices.demo.order.api.OrderAggregate
import com.itmo.microservices.demo.order.api.OrderEvents
import com.itmo.microservices.demo.order.api.enums.OrderStatus
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

    fun createNewOrder(id: UUID = UUID.randomUUID()): OrderEvents.OrderCreateEvent {
        return OrderEvents.OrderCreateEvent(id);
    }

    fun putItem(itemId: UUID, amount: Int): OrderEvents.OrderAddItemEvent {
        if (OrderStatus.COLLECTING !== status) {
            throw IllegalStateException("Order $id already is not collecting data. Current status $status")
        }
        return OrderEvents.OrderAddItemEvent(itemId, amount);
    }

    fun bookOrder(): OrderEvents.OrderBookEvent {
        if (OrderStatus.COLLECTING !== status) {
            throw IllegalStateException("Order $id already is not collecting data. Current status $status")
        }
        return OrderEvents.OrderBookEvent(OrderStatus.BOOKED)
    }

    fun fillDeliveryTime(slot: Int): OrderEvents.OrderFillDeliveryEvent {
        if (OrderStatus.COLLECTING !== status) {
            throw IllegalStateException("Order $id already is not collecting data. Current status $status")
        }
        return OrderEvents.OrderFillDeliveryEvent(slot);
    }

    @StateTransitionFunc
    fun createNewOrder(event: OrderEvents.OrderCreateEvent) {
        id = event.id;
        status = OrderStatus.COLLECTING
    }

    @StateTransitionFunc
    fun putItem(event: OrderEvents.OrderAddItemEvent) {
        itemsMap[event.itemId] = event.amount;
    }

    @StateTransitionFunc
    fun updateStatus(event: OrderEvents.OrderBookEvent) {
        status = event.status;
    }

    @StateTransitionFunc
    fun updateStatus(event: OrderEvents.OrderFillDeliveryEvent) {
        deliveryDuration = event.slot;
    }
}