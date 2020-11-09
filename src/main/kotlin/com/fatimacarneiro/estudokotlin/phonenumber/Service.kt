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

//    fun save(form: PhoneNumberForm) =
//            with(conversor.toConvertFormInEntity(form)) {
//                this.takeIf {
//                    validPrefix(it.ddd)
//                }?.let {
//                    dao.save(it)
//                } ?: throw DDDException("Invalid prefix")
//            }

//    fun save(form: PhoneNumberForm) =
//            with(conversor.toConvertFormInEntity(form)) {
//                if (!validPrefix(this.ddd))
//                    throw DDDException("Invalid prefix")
//                dao.save(this)
//            }


    fun validPrefix(dddForm: Int): Boolean {
        return DDD.values().asList().stream().anyMatch { ddd ->
            ddd.prefix == dddForm
        }
    }

    fun getAll(): MutableList<View> {
        val views = mutableListOf<View>()
        dao.findAll().forEach {
            views.add(conversor.toConvertEntityInView(it))
        }
        return views
    }

    fun findyByDDD(ddd: Int) = getByDDD(ddd).let {
        conversor.toConvertEntityInView(it.get())
    }

    private fun getByDDD(ddd: Int) = dao.findByDDD(ddd).stream().findFirst()
}
