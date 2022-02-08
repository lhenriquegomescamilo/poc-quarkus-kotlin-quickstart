package com.camilo.bill

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.apache.http.HttpStatus
import org.hamcrest.CoreMatchers
import org.junit.jupiter.api.Test

@QuarkusTest
class BillResourceTest {

    @Test
    fun `it should create bill`() {
        given()
            .contentType("application/json")
            .body(BillDto(description = "Aluguel"))
            .`when`()
            .post("/v1/bills")
            .then()
            .body("id", CoreMatchers.anything())
            .statusCode(HttpStatus.SC_OK)
    }
}