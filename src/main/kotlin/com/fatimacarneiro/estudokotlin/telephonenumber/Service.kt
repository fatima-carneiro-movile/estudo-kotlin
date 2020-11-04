package com.fatimacarneiro.estudokotlin.telephonenumber

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class Service(var dao: Dao, var conversor: Conversor) {

    @Transactional
    fun add(form: TelephoneNumberForm) {
        val entity: TelephoneNumber = conversor.toConvert(form)
        dao.save(entity)
    }

}
