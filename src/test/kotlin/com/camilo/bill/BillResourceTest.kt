package com.camilo.bill

import com.camilo.global.config.KafkaTestResourceLifecycleManager
import io.quarkus.test.common.QuarkusTestResource
import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import io.smallrye.reactive.messaging.providers.connectors.InMemoryConnector
import org.apache.http.HttpStatus
import org.junit.jupiter.api.Test
import javax.inject.Inject

@QuarkusTest
@QuarkusTestResource(KafkaTestResourceLifecycleManager::class)
class BillResourceTest {

    @Inject
    @javax.enterprise.inject.Any
    lateinit var connector: InMemoryConnector

    @Test
    fun `it should create bill`() {
        val billDto = BillDto(description = "Rent Car", price = 2000.31)

        given()
            .contentType("application/json")
            .body(billDto)
            .`when`()
            .post("/v1/bills")
            .then()
            .statusCode(HttpStatus.SC_NO_CONTENT)
    }
}