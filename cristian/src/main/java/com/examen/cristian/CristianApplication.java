package com.examen.cristian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@SpringBootApplication
public class CristianApplication {

	public static void main(String[] args) {
		SpringApplication.run(CristianApplication.class, args);
	}

}
