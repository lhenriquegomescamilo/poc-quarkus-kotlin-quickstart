package com.camilo.bill

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.future.await
import javax.ws.rs.Consumes
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response


@OptIn(DelicateCoroutinesApi::class, ExperimentalCoroutinesApi::class)
@Path("/v1/bills")
class BillResource(private val billService: BillCommandService) {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    suspend fun create(bill: BillDto): Response {
        return billService.create(bill).thenApply { Response.noContent().build() }.await()
    }
}