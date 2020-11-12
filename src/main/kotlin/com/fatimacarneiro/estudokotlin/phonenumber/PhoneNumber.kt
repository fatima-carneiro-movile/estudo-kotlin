package com.fatimacarneiro.estudokotlin.phonenumber

import org.springframework.data.annotation.Id
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType


@Entity
data class PhoneNumber(
        var ddd: Int,
        var number: Long,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    var id: Int = 0
}
