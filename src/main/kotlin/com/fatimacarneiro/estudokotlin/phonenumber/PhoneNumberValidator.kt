package com.fatimacarneiro.estudokotlin.phonenumber

import com.fatimacarneiro.estudokotlin.DDDException

fun isValidPrefix(dddForm: Int): Boolean {
    return DDD.values().asList().stream().anyMatch { ddd ->
        ddd.prefix == dddForm
    }
}

fun validPrefix(dddForm: Int) {
    if (!isValidPrefix(dddForm)) throw DDDException("Invalid prefix")
}