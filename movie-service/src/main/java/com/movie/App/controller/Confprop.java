package com.movie.App.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@ConfigurationProperties("movie-service")
@Component
@RefreshScope
public class Confprop {
	
private String username	;
private String password;

public String getpassword() {
	return password;
}

public void setpassword(String pass) {
	this.password = pass;
}

public String getusername() {
	return username;
}

public void setusername(String name) {
	this.username = name;
}



}
