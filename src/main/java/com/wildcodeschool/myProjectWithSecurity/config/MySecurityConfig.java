package com.wildcodeschool.myProjectWithSecurity.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;

@EnableWebSecurity //This object will describe the configuration for the security of your project.
public class MySecurityConfig extends WebSecurityConfigurerAdapter { //You're going to extend it so that it overrides the methods

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http
	         .authorizeRequests()
	         //   .anyRequest().authenticated()
	         		.antMatchers("/avengers/assemble").hasAnyRole("HERO", "DIRECTOR")
						//	.antMatchers("/avengers/assemble").hasAnyRole("DIRECTOR")
							.antMatchers("/secret-bases").hasAnyRole("DIRECTOR")
	         		.and()
	        .formLogin()
	            .and()
	        .httpBasic()
							.and()
					.exceptionHandling().accessDeniedPage("/unsuficientrights"); //.accessDeniedHandler(accessDeniedHandler);
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		auth.inMemoryAuthentication()
		.withUser("steve").password(encoder.encode("guy")).roles("HERO").and()
		.withUser("tony").password(encoder.encode("stark")).roles("HERO").and()
		.withUser("nick").password(encoder.encode("fury")).roles("DIRECTOR");
	}

	/*
	Writing http in this way allows you to add parameter blocks to your configuration. Each subsequent block is added with the and(). The default implementation should therefore be read as follows:
		During the configuration of http requests we add:
	a block called: authorizeRequests() to activate the security measures; and in order to send anyRequest() we want the user to first be authenticated()
		and() -- another block:
	we specify that authentication should done through a formLogin() -- or a login form
		and() -- another block:
	to configurehttpBasic() -- basic HTTP authentication.
	*/

}
