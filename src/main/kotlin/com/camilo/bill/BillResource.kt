package com.camilo.bill

import io.smallrye.mutiny.Uni
import io.smallrye.mutiny.coroutines.asUni
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import javax.ws.rs.Consumes
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.core.MediaType


@OptIn(DelicateCoroutinesApi::class, ExperimentalCoroutinesApi::class)
@Path("/v1/bills")
class BillResource(private val billService: BillService) {


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    fun create(bill: BillDto): Uni<Map<String, Long?>> {
        return GlobalScope.async { billService.create(bill) }.asUni().map { mapOf("id" to it) }
    }
}