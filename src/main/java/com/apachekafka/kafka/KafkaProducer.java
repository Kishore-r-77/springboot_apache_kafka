package com.apachekafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class KafkaProducer {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);
	
	@Value("${spring.kafka.topic.name}")
	private String topicName;
	
	private KafkaTemplate<String, String> kafkaTemplate;

	public void sendMessage(String message) {
		LOGGER.info(String.format("Message sent %s", message));
		kafkaTemplate.send(topicName, message);
	}
}
