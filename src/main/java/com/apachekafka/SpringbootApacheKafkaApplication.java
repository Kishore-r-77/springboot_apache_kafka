package com.apachekafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.apachekafka.kafka.JsonKafkaProducer")
public class SpringbootApacheKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApacheKafkaApplication.class, args);
	}

}
