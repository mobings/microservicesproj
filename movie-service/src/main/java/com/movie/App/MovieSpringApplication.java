package com.movie.App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SuppressWarnings("deprecation")
@SpringBootApplication
@EnableFeignClients
//@EnableResourceServer
@EnableDiscoveryClient
@EnableCircuitBreaker
public class MovieSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieSpringApplication.class, args);
	}

}
