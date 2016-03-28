package com.sjsu.cmpe275.lab2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class RestAssign273Application {

	public static void main(String[] args) {

		SpringApplication.run(RestAssign273Application.class, args);
	}
}
