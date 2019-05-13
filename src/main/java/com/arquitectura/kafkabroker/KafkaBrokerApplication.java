package com.arquitectura.kafkabroker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaBrokerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaBrokerApplication.class, args);
	}

}
