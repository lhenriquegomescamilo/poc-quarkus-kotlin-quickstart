package com.camilo.bill

import kotlinx.coroutines.future.await
import org.eclipse.microprofile.reactive.messaging.Channel
import org.eclipse.microprofile.reactive.messaging.Emitter
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class BillCommandService(@Channel("bill-out") private val billdEmitter: Emitter<BillDto>) {

    suspend fun create(bill: BillDto) {
        billdEmitter.send(bill).await()
    }
}
