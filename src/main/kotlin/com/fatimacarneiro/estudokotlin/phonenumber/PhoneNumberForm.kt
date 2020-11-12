package com.fatimacarneiro.estudokotlin.phonenumber

import javax.validation.constraints.Max
import javax.validation.constraints.Min

class PhoneNumberForm {

    @Min(11, message = "Invalid ddd")
    @Max(90, message = "Invalid ddd")
    var ddd: Int = 0

    @Min(10000000, message = "The phone number must be at least 8 digits")
    @Max(999999999, message = "Phone number greater than 9 digits")
    var number: Long = 0
}
