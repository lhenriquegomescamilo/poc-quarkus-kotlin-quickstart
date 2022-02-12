package com.camilo.bill

import io.quarkus.hibernate.orm.panache.kotlin.PanacheCompanion
import io.quarkus.hibernate.reactive.panache.PanacheEntityBase
import javax.persistence.*

@Cacheable
@Entity
@Table(name = "tb_bill")
data class Bill(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column
    val description: String = "",

    @Column
    val price: Double = 0.0
) : PanacheEntityBase() {
}
