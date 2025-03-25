package com.ambev.revenda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.ambev.revenda")
public class RevendaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RevendaApplication.class, args);
	}

}
