package com.camilo.bill

import io.quarkus.hibernate.reactive.panache.Panache
import io.smallrye.mutiny.groups.UniAwait
import org.eclipse.microprofile.reactive.messaging.Channel
import org.eclipse.microprofile.reactive.messaging.Emitter
import org.eclipse.microprofile.reactive.messaging.Incoming
import org.slf4j.LoggerFactory
import java.util.concurrent.CompletionStage
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class BillWorkerService {

    private val log = LoggerFactory.getLogger(BillWorkerService::class.java)

    @Incoming("bill-in")
    suspend fun onCreateBill(billDto: BillDto): UniAwait<Bill> {
        log.info("On Creating bill")
        return Panache.withTransaction { billDto.toEntity().persist<Bill>() }.await()
    }
}
