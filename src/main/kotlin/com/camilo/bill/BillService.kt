package com.camilo.bill

import java.util.*
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class BillService {
    suspend fun create(bill: BillDto): Long {
        return Random().nextLong()
    }

}
