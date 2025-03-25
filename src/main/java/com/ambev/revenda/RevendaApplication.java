package com.ambev.revenda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.ambev.revenda.integration")
@SpringBootApplication(scanBasePackages = "com.ambev.revenda")
public class RevendaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RevendaApplication.class, args);
	}

}
