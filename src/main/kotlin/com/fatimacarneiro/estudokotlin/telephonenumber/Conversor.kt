package com.fatimacarneiro.estudokotlin.telephonenumber

import org.springframework.stereotype.Component

@Component
class Conversor() {

    fun toConvert(form: TelephoneNumberForm): TelephoneNumber {
        val entity = TelephoneNumber()
        entity.ddd = form.ddd
        entity.number = form.number

        return entity
    }

}