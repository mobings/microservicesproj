package com.ait.proj.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableResourceServer
@RestController
@RefreshScope
public class MicroSvcClient {

	@Autowired
	@Lazy
	private RestTemplate template;

	@Value("${movie-service.username}")
	private String getconfigsvrvalue;
	
	
	
	private String cinemaurl="http://localhost:6666/message";
	private String movieUrl="http://localhost:7777//movies/cinemas/1";



	@GetMapping("/cinemaurl")
	public String getcin(String url) {
		return template.getForObject(cinemaurl, String.class);
	
	}
	
	
	@GetMapping("/movieurl")
	public List<Cinema> getmovie(String url) {
		return template.getForObject(movieUrl, List.class);
	
	}
	
	
	@GetMapping("/getname")
	public String getNNam() {
		
		return "returning from Git repo "+this.getconfigsvrvalue;
	}
	
	
	@GetMapping("/adminonly")
	public String adminonly() {
		
		return "For Admin only access";
	}
	
	@GetMapping("/baonly")
	public String baonly() {
		
		return "For BA Role only";
	}
	
		
	
	
	public static void main(String[] args) {
		SpringApplication.run(MicroSvcClient.class, args);
	}

	@Bean
	public RestTemplate template() {
		return new RestTemplate();
	}

}
