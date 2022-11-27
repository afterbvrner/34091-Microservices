package com.itmo.microservices.demo.order.api.controller

import com.itmo.microservices.demo.order.api.model.*
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/order")
class OrderController {

    @PostMapping
    @Operation(
        summary = "Create / Update order",
        responses = [
            ApiResponse(description = "OK", responseCode = "200"),
            ApiResponse(description = "Bad request", responseCode = "400", content = [Content()]),
            ApiResponse(description = "Unauthorized", responseCode = "403", content = [Content()])
        ],
        security = [SecurityRequirement(name = "bearerAuth")]
    )
    fun saveOrder(
        @RequestBody request: SaveOrderRequest,
        @Parameter(hidden = true) @AuthenticationPrincipal requester: UserDetails
    ): SaveOrderResponse {
        TODO()
    }

    @PostMapping("/payment/{orderId}")
    @Operation(
        summary = "Fulfil order",
        responses = [
            ApiResponse(description = "OK", responseCode = "200"),
            ApiResponse(description = "Order not found", responseCode = "404", content = [Content()]),
            ApiResponse(description = "Unauthorized", responseCode = "403", content = [Content()])
        ],
        security = [SecurityRequirement(name = "bearerAuth")]
    )
    fun fulfil(
        @PathVariable orderId: Long,
        @Parameter(hidden = true) @AuthenticationPrincipal requester: UserDetails
    ): PaymentInformation {
        TODO()
    }

    @PostMapping("/payment/{orderId}/deliverySlot")
    @Operation(
        summary = "Select delivery slot for order",
        responses = [
            ApiResponse(description = "OK", responseCode = "200"),
            ApiResponse(description = "Order not found", responseCode = "404", content = [Content()]),
            ApiResponse(description = "Unauthorized", responseCode = "403", content = [Content()])
        ],
        security = [SecurityRequirement(name = "bearerAuth")]
    )
    fun selectDeliverySlot(
        @PathVariable orderId: Long,
        @RequestBody request: SelectDeliverySlotRequest,
        @Parameter(hidden = true) @AuthenticationPrincipal requester: UserDetails
    ): DeliverySlot {
        TODO()
    }
}