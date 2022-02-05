package com.camilo.greeting

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.apache.http.HttpStatus
import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

@QuarkusTest
class GreetingResourceTest {

    @Test
    fun `it should return hello greeting`() {
        given().`when`().get("/greetings")
            .then()
            .statusCode(HttpStatus.SC_OK)
            .body("message", equalTo("hello"))
    }
}