package com.kath.RESTService.JobShop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
//https://www.callicoder.com/spring-boot-rest-api-tutorial-with-mysql-jpa-hibernate/
//http://localhost:8080/api/jobs
//SET GLOBAL time_zone = '+1:00';

@SpringBootApplication
@EnableJpaAuditing
public class JobShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobShopApplication.class, args);
	}
}
