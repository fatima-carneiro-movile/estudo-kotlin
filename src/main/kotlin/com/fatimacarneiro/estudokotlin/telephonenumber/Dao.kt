package com.fatimacarneiro.estudokotlin.telephonenumber

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
abstract class Dao : CrudRepository<TelephoneNumber, Int>
