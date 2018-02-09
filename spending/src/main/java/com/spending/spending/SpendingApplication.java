package com.spending.spending;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@ComponentScan(value = "com.spending")
public class SpendingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpendingApplication.class, args);
	}
}
