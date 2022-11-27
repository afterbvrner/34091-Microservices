package com.itmo.microservices.demo.order.api.model

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude

//for example
@JsonInclude(JsonInclude.Include.NON_NULL)
class SelectDeliverySlotRequest @JsonCreator constructor(
    val availableSlots: List<DeliverySlot>
)