package com.fatimacarneiro.estudokotlin.phonenumber

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface Dao : CrudRepository<PhoneNumber, Int> {

    @Query(value = "SELECT pn FROM PhoneNumber pn WHERE pn.ddd = :ddd")
    fun findByDDD(ddd: Int): List<PhoneNumber>
}
