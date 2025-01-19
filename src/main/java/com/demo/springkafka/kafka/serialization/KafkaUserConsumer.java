package com.demo.springkafka.kafka.serialization;

import com.demo.springkafka.kafka.basics.KafkaConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaUserConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaUserConsumer.class);

    @KafkaListener(
            topics = KafkaConstants.TOPIC_NAME,
            groupId = KafkaConstants.GROUP_ID
    )
    public void consume(User user) {
        LOGGER.info("Consumed user: {}", user);
    }
}
