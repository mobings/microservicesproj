package edu.tus.authenticationservice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;



@Configuration
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter{
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception{
		return super.authenticationManagerBean();
	}
	
	@Override
	@Bean
	public UserDetailsService userDetailsServiceBean() throws Exception{
		return super.userDetailsServiceBean();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication()
		.withUser("moby.dilson").password("{noop}pa55word")
		.roles("USER", "ADMIN")
		.and()
		.withUser("dany.doe").password("{noop}password")
		.roles("USER")
		.and().withUser("doddy.doe").password("{noop}password")
		.roles("BA");
	}

}
