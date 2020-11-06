package com.fatimacarneiro.estudokotlin.telephonenumber

import com.fatimacarneiro.estudokotlin.DDDException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class Service(var dao: Dao, var conversor: Conversor) {

    @Transactional
    fun save(form: PhoneNumberForm) {
        val entity: PhoneNumber = conversor.toConvert(form)
        if (!validPrefix(form.ddd)) throw DDDException("Invalid prefix")

        dao.save(entity)
    }

    fun validPrefix(dddForm: Int): Boolean {
        return DDD.values().asList().stream().anyMatch { ddd ->
            ddd.prefix == dddForm
        }
    }

}
