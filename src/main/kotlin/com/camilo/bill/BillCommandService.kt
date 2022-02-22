package com.camilo.bill

import org.eclipse.microprofile.reactive.messaging.Channel
import org.eclipse.microprofile.reactive.messaging.Emitter
import java.util.concurrent.CompletionStage
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class BillCommandService(@Channel("bill-in") private val emitter: Emitter<BillDto>) {

    suspend fun create(bill: BillDto): CompletionStage<Void> = emitter.send(bill)
}
