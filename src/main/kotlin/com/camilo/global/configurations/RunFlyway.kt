package com.camilo.global.configurations

import io.quarkus.runtime.StartupEvent
import org.eclipse.microprofile.config.inject.ConfigProperty
import org.flywaydb.core.Flyway
import org.slf4j.LoggerFactory
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.event.Observes


@ApplicationScoped
class RunFlyway(
    @ConfigProperty(name = "quarkus.flyway.migrate-at-start")
    private val isRunMigration: Boolean,
    @ConfigProperty(name = "quarkus.datasource.jdbc.url")
    private val url: String,
    @ConfigProperty(name = "quarkus.datasource.username")
    private val username: String,
    @ConfigProperty(name = "quarkus.datasource.password")
    private val password: String
) {

    private val logger = LoggerFactory.getLogger(RunFlyway::class.java)

    fun runFlywayMigration(@Observes event: StartupEvent) {
        if (isRunMigration) {
            try {
                val flyway = Flyway.configure()
                    .dataSource(url, username, password)
                    .load()
                flyway.migrate()
            } catch (e: Exception) {
                logger.warn("Somethign wrong on run flyway migration: {}", e.message, e)
            }

        }
    }
}