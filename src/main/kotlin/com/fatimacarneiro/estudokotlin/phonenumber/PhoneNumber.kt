package com.fatimacarneiro.estudokotlin.phonenumber

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class PhoneNumber(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        var id: Int = 0,
        var ddd: Int,
        var number: Long
)
