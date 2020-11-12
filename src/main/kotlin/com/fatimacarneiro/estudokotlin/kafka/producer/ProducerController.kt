//package com.fatimacarneiro.estudokotlin.kafka.producer
//
//import com.fatimacarneiro.estudokotlin.phonenumber.PhoneNumber
//import com.fatimacarneiro.estudokotlin.phonenumber.PhoneNumberForm
//import org.slf4j.LoggerFactory
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.beans.factory.annotation.Value
//import org.springframework.http.HttpEntity
//import org.springframework.http.HttpStatus
//import org.springframework.http.ResponseEntity
//import org.springframework.kafka.core.KafkaTemplate
//import org.springframework.web.bind.annotation.*
//
//
//@RestController
//class ProducerController(
//        @Autowired val kafkaTemplate: KafkaTemplate<String, String>
//) {
//    private val log = LoggerFactory.getLogger(ProducerController::class.java)
//
//    @PostMapping("producer")
//    fun produceMessage(@RequestBody phoneNumber: PhoneNumber): HttpEntity<Any?> {
//        log.info("producerMessage, text=$phoneNumber")
//        kafkaTemplate.send("TESTE", phoneNumber.toString())
//        return ResponseEntity(HttpStatus.CREATED)
//    }
//}