package com.camilo.global.config

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager
import io.smallrye.reactive.messaging.providers.connectors.InMemoryConnector

class KafkaTestResourceLifecycleManager : QuarkusTestResourceLifecycleManager {
    override fun start(): MutableMap<String, String> {
        return mutableMapOf<String, String>().apply {
            putAll(InMemoryConnector.switchIncomingChannelsToInMemory("bill-in"))
        }
    }

    override fun stop() {
        InMemoryConnector.clear()
    }
}