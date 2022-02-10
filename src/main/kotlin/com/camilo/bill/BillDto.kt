package com.camilo.bill

import com.fasterxml.jackson.annotation.JsonProperty

data class BillDto(
    val description: String = "",
    val price: Double = 0.0
)
