package com.camilo.bill

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class BillRepository : PanacheRepository<Bill> {

}