package kafka

import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.clients.producer.ProducerRecord

class Producer {

    static void send(String message) {

        Properties props = new Properties()

        props.put(
                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                "localhost:9092")

        props.put(
                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringSerializer")

        props.put(
                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringSerializer")

        KafkaProducer<String, String> producer =
                new KafkaProducer<>(props)

        producer.send(
                new ProducerRecord<>(
                        "demo-topic",
                        message))

        producer.close()
    }
}