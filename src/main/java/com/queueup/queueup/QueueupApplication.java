package com.queueup.queueup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class QueueupApplication {

	public static void main(String[] args) {
		SpringApplication.run(QueueupApplication.class, args);
	}

}
