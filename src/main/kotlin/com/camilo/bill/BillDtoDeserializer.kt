package com.camilo.bill

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer

class BillDtoDeserializer(): ObjectMapperDeserializer<BillDto>(BillDto::class.java);