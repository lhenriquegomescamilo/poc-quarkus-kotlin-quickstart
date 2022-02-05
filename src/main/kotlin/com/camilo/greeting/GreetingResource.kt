package com.camilo.greeting

import io.smallrye.mutiny.Uni
import io.smallrye.mutiny.coroutines.asUni
import io.smallrye.mutiny.coroutines.awaitSuspending
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import javax.enterprise.context.ApplicationScoped
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/greetings")
@OptIn(DelicateCoroutinesApi::class)
class GreetingResource(
    private val greetingService: GreetingService
) {


    @OptIn(ExperimentalCoroutinesApi::class)
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun getOne(): Uni<Greeting> = GlobalScope.async { greetingService.create() }.asUni()


    @GET
    @Path("/one")
    @Produces(MediaType.TEXT_PLAIN)
    suspend fun getOneAsString() = "getOne"

}