package com.camilo.bill

import io.quarkus.hibernate.reactive.panache.Panache
import io.smallrye.context.SmallRyeThreadContext
import io.smallrye.context.api.CurrentThreadContext
import io.smallrye.context.api.ThreadContextConfig
import io.smallrye.mutiny.Uni
import io.smallrye.mutiny.coroutines.awaitSuspending
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.eclipse.microprofile.context.ThreadContext
import javax.enterprise.context.ApplicationScoped
import javax.transaction.TransactionManager
import javax.transaction.Transactional

@ApplicationScoped
class BillService {

    @CurrentThreadContext(unchanged = [ThreadContext.TRANSACTION])
    fun create(bill: BillDto): Uni<Bill>{
        val entity = bill.toEntity()
//        Panache.withTransaction { Uni.createFrom().item(billRepository.persist(entity)) }.awaitSuspending()
//        Panache.withTransaction {  }.awaitSuspending()
        return entity.persist()
    }

}
