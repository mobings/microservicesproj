package com.cinema.App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class CinemaSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CinemaSpringApplication.class, args);
	}

}
