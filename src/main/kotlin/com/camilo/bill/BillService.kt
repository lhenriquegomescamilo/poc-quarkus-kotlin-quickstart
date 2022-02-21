package com.camilo.bill

import io.smallrye.context.api.CurrentThreadContext
import io.smallrye.mutiny.Uni
import io.smallrye.mutiny.coroutines.awaitSuspending
import org.eclipse.microprofile.context.ThreadContext
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class BillService {


    suspend fun create(bill: BillDto): BillDto {
        val entity = bill.toEntity()
        return entity.persist<Bill>().map { it.toDto() }.awaitSuspending()
    }

}
