package com.camilo.greeting

import kotlinx.coroutines.DelicateCoroutinesApi
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class GreetingService {
    suspend fun create() = Greeting("hello")
}