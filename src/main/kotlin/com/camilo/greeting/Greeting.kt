package com.camilo.greeting

import com.fasterxml.jackson.annotation.JsonProperty

data class Greeting(
    @field:JsonProperty("message")
    val message: String? = null
)
