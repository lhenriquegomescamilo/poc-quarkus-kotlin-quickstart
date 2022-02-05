package com.camilo.greeting

import kotlinx.coroutines.DelicateCoroutinesApi
import javax.enterprise.context.ApplicationScoped

@OptIn(DelicateCoroutinesApi::class)
@ApplicationScoped
class GreetingService {
    suspend fun create() = Greeting("hello")
}