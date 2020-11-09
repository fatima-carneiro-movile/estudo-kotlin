package com.fatimacarneiro.estudokotlin.phonenumber

import com.fatimacarneiro.estudokotlin.DDDException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class Service(
        val dao: Dao,
        val conversor: Conversor
) {

    @Transactional
    fun save(form: PhoneNumberForm) {
        val entity: PhoneNumber = conversor.toConvertFormInEntity(form)
        if (!validPrefix(form.ddd)) throw DDDException("Invalid prefix")

        dao.save(entity)
    }

    fun validPrefix(dddForm: Int): Boolean {
        return DDD.values().asList().stream().anyMatch { ddd ->
            ddd.prefix == dddForm
        }
    }

    fun getAll(): List<View> {
        return dao.findAll().map {
            conversor.toConvertEntityInView(it)
        }
    }

    fun findByDDD(ddd: Int): View = getByDDD(ddd).let {
        conversor.toConvertEntityInView(it.get())
    }

    private fun getByDDD(ddd: Int) = dao.findByDDD(ddd).stream().findFirst()
}
