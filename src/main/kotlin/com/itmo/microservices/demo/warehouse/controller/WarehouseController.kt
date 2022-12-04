package com.itmo.microservices.demo.warehouse.controller

import com.itmo.microservices.demo.warehouse.model.CatalogItemDto
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
@RequestMapping("/items")
class WarehouseController {

    @GetMapping
    @Operation(
        summary = "Get items",
        responses = [
            ApiResponse(description = "OK", responseCode = "200"),
            ApiResponse(description = "Unauthorized", responseCode = "403", content = [Content()])
        ],
        security = [SecurityRequirement(name = "bearerAuth")]
    )
    fun getOrder(
        @RequestParam(required = true) available: Boolean,
        @RequestParam(required = true) size: Int,
        @Parameter(hidden = true) @AuthenticationPrincipal requester: UserDetails
    ): List<CatalogItemDto> {
        TODO()
    }
}