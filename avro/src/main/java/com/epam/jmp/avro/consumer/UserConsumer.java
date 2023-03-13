package com.epam.jmp.avro.consumer;

import com.epam.jmp.avro.User;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class UserConsumer {
    @KafkaListener(topics = "users")
    public void consume(ConsumerRecord<String, User> userRecord) {
        System.out.println("User record consumed: " + userRecord.value().getName());
    }
}
