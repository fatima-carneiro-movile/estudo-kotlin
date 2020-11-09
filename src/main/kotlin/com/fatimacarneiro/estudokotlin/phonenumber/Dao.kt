package com.fatimacarneiro.estudokotlin.phonenumber

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface Dao : CrudRepository<PhoneNumber, Int> {

    fun findByDDD(ddd: Int): MutableList<PhoneNumber>
}
