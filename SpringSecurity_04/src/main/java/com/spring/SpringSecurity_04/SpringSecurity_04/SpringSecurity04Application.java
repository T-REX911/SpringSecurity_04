package com.spring.SpringSecurity_04.SpringSecurity_04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class SpringSecurity04Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurity04Application.class, args);
	}

}
