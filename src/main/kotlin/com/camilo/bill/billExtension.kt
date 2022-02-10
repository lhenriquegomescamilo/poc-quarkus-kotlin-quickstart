package com.camilo.bill

fun BillDto.toEntity() = Bill(description = this.description, price = this.price)