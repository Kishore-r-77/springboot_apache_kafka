package com.apachekafka.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apachekafka.kafka.JsonKafkaProducer;
import com.apachekafka.payload.User;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/kafka")
@AllArgsConstructor
public class JsonMessageController {
	
	private JsonKafkaProducer kafkaProducer;
	
	@GetMapping("/publish")
	public ResponseEntity<String> publish(@RequestBody User user){
		kafkaProducer.sendMessage(user);
		return ResponseEntity.ok("Json Message sent to kafka topic");
	}

}
