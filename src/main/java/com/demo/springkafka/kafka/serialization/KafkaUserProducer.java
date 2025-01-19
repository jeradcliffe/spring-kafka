package com.demo.springkafka.kafka.serialization;

import com.demo.springkafka.kafka.basics.KafkaConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaUserProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaUserProducer.class);

    private final KafkaTemplate<String, User> kafkaTemplate;

    public KafkaUserProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(User user) {
        LOGGER.info("Message sent -> {}", user.toString());
        Message<User> message = MessageBuilder
                .withPayload(user)
                .setHeader(KafkaHeaders.TOPIC, KafkaConstants.TOPIC_NAME)
                .build();
        kafkaTemplate.send(message);
    }
}
