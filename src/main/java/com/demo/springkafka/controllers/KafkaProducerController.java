package com.demo.springkafka.controllers;

import com.demo.springkafka.kafka.basics.KafkaProducer;
import com.demo.springkafka.kafka.serialization.KafkaUserProducer;
import com.demo.springkafka.kafka.serialization.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/kafka")
public class KafkaProducerController {

    private final KafkaProducer kafkaProducer;
    private final KafkaUserProducer kafkaUserProducer;

    public KafkaProducerController(KafkaProducer kafkaProducer, KafkaUserProducer kafkaUserProducer) {
        this.kafkaProducer = kafkaProducer;
        this.kafkaUserProducer = kafkaUserProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message) {
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok(message);
    }

    @PostMapping("/publish/user")
    public ResponseEntity<String> sendUserMessage(@RequestBody User user) {
        kafkaUserProducer.sendMessage(user);
        return ResponseEntity.ok(String.format("User: %s", user));
    }
}
