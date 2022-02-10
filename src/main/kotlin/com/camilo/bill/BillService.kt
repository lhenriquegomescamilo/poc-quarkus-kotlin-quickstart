package com.camilo.bill

import javax.enterprise.context.ApplicationScoped
import javax.transaction.Transactional

@ApplicationScoped
class BillService(
    private val billRepository: BillRepository
) {

    @Transactional
    suspend fun create(bill: BillDto): Long? {
        val entity = bill.toEntity()
        billRepository.persist(entity)
        return entity.id
    }

}
