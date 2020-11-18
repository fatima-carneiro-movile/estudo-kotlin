package com.fatimacarneiro.estudokotlin.phonenumber

import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.serialization.Serializable
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
@Serializable
data class PhoneNumber(
        @Id
        @JsonProperty("id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        var id: Int = 0,

        @JsonProperty("ddd")
        var ddd: Int,

        @JsonProperty("number")
        var number: Long,
)
