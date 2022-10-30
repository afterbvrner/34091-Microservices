package com.itmo.microservices.demo.aggregates.config

import com.itmo.microservices.demo.aggregates.api.OrderAggregate
import com.itmo.microservices.demo.aggregates.logic.OrderAggregateState
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import ru.quipy.core.EventSourcingServiceFactory
import java.util.*

//@Configuration
//class OrderDemoConfig {
//
//    @Autowired
//    private lateinit var eventSourcingServiceFactory: EventSourcingServiceFactory
//
//    @Bean
//    fun orderService() = eventSourcingServiceFactory.create<UUID, OrderAggregate, OrderAggregateState>()
//}