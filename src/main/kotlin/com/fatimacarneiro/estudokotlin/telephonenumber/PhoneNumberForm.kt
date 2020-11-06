package com.fatimacarneiro.estudokotlin.telephonenumber

import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.Size

class PhoneNumberForm {
    @Size(min = 2, max = 4, message = "Invalid prefix size. Ex: 00")
    var ddd: Int = 0

    @Min(8, message = "The phone number must be at least 8 digits")
    @Max(9, message = "Phone number greater than 9 digits")
    var number: Long = 0
}
