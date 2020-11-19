package com.fatimacarneiro.estudokotlin.kafka

import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory

@Configuration
class ProducerConfiguration {
    private val stringSerializer: String = StringSerializer::class.java.name


    @Bean
    fun producerFactory(@Value("\${kafka.bootstrap-servers}") server: String): ProducerFactory<String, String> =
            DefaultKafkaProducerFactory(

                    mapOf(
                            ProducerConfig.BOOTSTRAP_SERVERS_CONFIG to server,
                            ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG to stringSerializer,
                            ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG to stringSerializer
                    )
            )

    @Bean
    fun kafkaTemplate(producerFactory: ProducerFactory<String, String>): KafkaTemplate<String, String> {
        return KafkaTemplate(producerFactory)
    }
}