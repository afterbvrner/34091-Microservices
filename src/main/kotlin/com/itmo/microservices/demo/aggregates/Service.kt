package com.itmo.microservices.demo.aggregates

import com.itmo.microservices.demo.aggregates.api.OrderAggregate
import com.itmo.microservices.demo.aggregates.logic.OrderAggregateState
import com.itmo.microservices.demo.aggregates.logic.createOrder
import com.itmo.microservices.demo.tasks.api.model.TaskModel
import com.itmo.microservices.demo.tasks.api.service.TaskService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.quipy.core.EventSourcingService
import ru.quipy.core.EventSourcingServiceFactory
import java.util.UUID

@RestController
@RequestMapping("/orders")
class Service @Autowired constructor(val eventSourcingServiceFactory: EventSourcingServiceFactory) {

    @PostMapping("/create")
    fun createOrder() {
        eventSourcingServiceFactory.create<UUID, OrderAggregate, OrderAggregateState>().create {
            it.createOrder()
        }
    }
}