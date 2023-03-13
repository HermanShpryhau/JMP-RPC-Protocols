package com.epam.jmp.avro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class AvroApplication {

	public static void main(String[] args) {
		SpringApplication.run(AvroApplication.class, args);
	}

}
