package com.apachekafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.apachekafka.payload.User;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JsonKafkaProducer {

	@Value("${spring.kafka.topic-json.name}")
	private String topicNameJson;

	private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

	private KafkaTemplate<String, User> kafkaTemplate;

	public void sendMessage(User data) {
		LOGGER.info("Message sent => %s", data.toString());
		Message<User> message = MessageBuilder.withPayload(data).setHeader(KafkaHeaders.TOPIC, topicNameJson).build();

		kafkaTemplate.send(message);
	}

}
