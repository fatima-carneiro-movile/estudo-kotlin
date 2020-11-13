package com.fatimacarneiro.estudokotlin.phonenumber

import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.common.serialization.StringSerializer
import java.util.*


fun producer(phoneNumber: PhoneNumber): KafkaProducer<String, PhoneNumber> {
    val producer = KafkaProducer<String, PhoneNumber>(properties())
    producer.send(record(phoneNumber))
    return producer
}

private fun record(phoneNumber: PhoneNumber): ProducerRecord<String, PhoneNumber> {
    return ProducerRecord("NEW_PHONE", phoneNumber)
}

private fun properties(): Properties {
    val server = "127.0.0.1:43013:8080"
    val stringSerializer: String = StringSerializer::class.java.name

    val properties = Properties()
    properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, server)
    properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, stringSerializer)
    properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, stringSerializer)

    return properties
}

