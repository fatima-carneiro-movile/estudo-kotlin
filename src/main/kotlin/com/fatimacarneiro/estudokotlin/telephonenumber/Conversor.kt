package com.fatimacarneiro.estudokotlin.telephonenumber

import org.springframework.stereotype.Component

@Component
class Conversor() {

    fun toConvert(form: PhoneNumberForm): PhoneNumber {
        val entity = PhoneNumber()
        entity.ddd = form.ddd
        entity.number = form.number

        return entity
    }

}