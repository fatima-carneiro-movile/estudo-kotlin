package com.fatimacarneiro.estudokotlin.phonenumber

import org.springframework.stereotype.Component

@Component
class Conversor {

    fun toConvertFormInEntity(form: PhoneNumberForm): PhoneNumber {
        val entity = PhoneNumber()
        entity.ddd = form.ddd
        entity.number = form.number

        return entity
    }

    fun toConvertEntityInView(entity: PhoneNumber) = View(
            ddd = entity.ddd,
            number = entity.number
    )
}