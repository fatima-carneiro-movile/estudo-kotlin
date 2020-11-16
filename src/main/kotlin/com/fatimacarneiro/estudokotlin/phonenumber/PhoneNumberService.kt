package com.fatimacarneiro.estudokotlin.phonenumber

import com.fatimacarneiro.estudokotlin.kafka.PhoneNumberProducer
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PhoneNumberService(
        val phoneNumberDao: PhoneNumberDao,
        val phoneNumberProducer: PhoneNumberProducer
) {

    @Transactional
    fun save(form: PhoneNumberForm) {
        val entity: PhoneNumber = form.toEntity()
        validPrefix(form.ddd)
        phoneNumberDao.save(entity)
        phoneNumberProducer.producer(entity)
    }

    fun getAll(): List<PhoneNumberView> {
        return phoneNumberDao.findAll().map {
            it.toView()
        }
    }

    fun findByDDD(ddd: Int): PhoneNumberView = getByDDD(ddd).get().toView()

    private fun PhoneNumber.toView(): PhoneNumberView {
        return PhoneNumberView(ddd, number)
    }

    private fun PhoneNumberForm.toEntity(): PhoneNumber {
        return PhoneNumber(0, ddd, number)
    }

    private fun getByDDD(ddd: Int) = phoneNumberDao.findByDDD(ddd).stream().findFirst()
}
