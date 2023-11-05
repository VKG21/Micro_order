package com.order.OrderService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@RefreshScope
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

	
	@Bean
	@Profile("dev")
	public RestTemplate restTemplate() {
		System.out.println("bean is initillized for dev envoirement in java");
		return new RestTemplate();
	}
}
