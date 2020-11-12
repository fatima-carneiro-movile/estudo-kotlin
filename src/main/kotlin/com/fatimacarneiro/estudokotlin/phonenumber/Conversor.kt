package com.fatimacarneiro.estudokotlin.phonenumber

import org.springframework.stereotype.Component

@Component
class Conversor {

    fun toConvertFormInEntity(form: PhoneNumberForm): PhoneNumber {
        return PhoneNumber(0, form.ddd, form.number)
    }

    fun toConvertEntityInView(entity: PhoneNumber) = View(
            ddd = entity.ddd,
            number = entity.number
    )
}