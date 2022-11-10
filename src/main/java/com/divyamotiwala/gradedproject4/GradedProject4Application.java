package com.divyamotiwala.gradedproject4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;

@SpringBootApplication
@EnableWebSecurity
public class GradedProject4Application {

	public static void main(String[] args) {
		SpringApplication.run(GradedProject4Application.class, args);
	}

}
