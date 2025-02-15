package com.demo.springkafka.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import static com.demo.springkafka.kafka.basics.KafkaConstants.TOPIC_NAME;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic createTopicOnStartup() {
        return TopicBuilder.name(TOPIC_NAME).build();
    }
}
