package com.fatimacarneiro.estudokotlin.kafka


import com.fatimacarneiro.estudokotlin.phonenumber.PhoneNumber
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Repository

@Repository
class PhoneNumberProducer(
        @Value("\${kafka.topic-name}") val topicName: String,
        @Autowired val kafkaTemplate: KafkaTemplate<String, String>,
) {

    fun template(phoneNumber: PhoneNumber): KafkaTemplate<String, String> {
        kafkaTemplate.send(topicName, phoneNumber.toString())
        return kafkaTemplate
    }

}