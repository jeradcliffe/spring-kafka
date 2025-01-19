package com.demo.springkafka.kafka.basics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static com.demo.springkafka.kafka.basics.KafkaConstants.GROUP_ID;
import static com.demo.springkafka.kafka.basics.KafkaConstants.TOPIC_NAME;

@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = TOPIC_NAME, groupId = GROUP_ID)
    public void consume(String message) {
        LOGGER.info("Consumer | topic: {} | message: {}", TOPIC_NAME, message);
    }
}
