package com.fatimacarneiro.estudokotlin.kafka

import com.fatimacarneiro.estudokotlin.phonenumber.PhoneNumber
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.stereotype.Repository
import java.util.*

import com.google.gson.Gson

@Repository
class PhoneNumberProducer {

    fun producer(phoneNumber: PhoneNumber): KafkaProducer<String, String?> {
        val producer = KafkaProducer<String, String?>(properties())
        producer.send(record(phoneNumber))
        return producer
    }

    private fun parseObjetcInJson(phoneNumber: PhoneNumber): String? {
        val gson = Gson()
        return gson.toJson(phoneNumber)
    }

    private fun record(phoneNumber: PhoneNumber): ProducerRecord<String, String?> {
        val json = parseObjetcInJson(phoneNumber)
        return ProducerRecord("NEW_PHONE", json)
    }

    private fun properties(): Properties {
        val server = "localhost:9092"
        val stringSerializer: String = StringSerializer::class.java.name

        val properties = Properties()
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, server)
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, stringSerializer)
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, stringSerializer)

        return properties
    }
}