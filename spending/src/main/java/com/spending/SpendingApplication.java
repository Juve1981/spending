package com.spending;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableJpaRepositories("com.spending.repository")
@ComponentScan(basePackages = "com.spending")
public class SpendingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpendingApplication.class, args);
	}
}
