package com.fatimacarneiro.estudokotlin.phonenumber

import com.fatimacarneiro.estudokotlin.DDDException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class Service(
        val dao: Dao
) {

    @Transactional
    fun save(form: PhoneNumberForm) {
        val entity: PhoneNumber = form.toEntity()
        if (!validPrefix(form.ddd)) throw DDDException("Invalid prefix")

        dao.save(entity)
    }

//    fun sendToKakfa(phoneNumber: PhoneNumber) {
//        producerControllerKafka.produceMessage(phoneNumber)
//    }

    fun validPrefix(dddForm: Int): Boolean {
        return DDD.values().asList().stream().anyMatch { ddd ->
            ddd.prefix == dddForm
        }
    }

    fun getAll(): List<View> {
        return dao.findAll().map {
            it.toView()
        }
    }

    fun findByDDD(ddd: Int): View = getByDDD(ddd).get().toView()

    private fun PhoneNumberForm.toEntity(): PhoneNumber {
        return PhoneNumber(this.ddd, this.number)
    }

    private fun PhoneNumber.toView(): View {
        return View(this.ddd, this.number)
    }

    private fun getByDDD(ddd: Int) = dao.findByDDD(ddd).stream().findFirst()
}
