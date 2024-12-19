package com.spring_boot.rest_service.Rest_Api_Redis_Cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RestApiRedisCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiRedisCacheApplication.class, args);
	}

}
