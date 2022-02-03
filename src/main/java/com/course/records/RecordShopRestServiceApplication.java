package com.course.records;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RecordShopRestServiceApplication {

	@Bean
	public CommandLineRunner sanityCheck() {
		return  args -> System.out.println("Shop open for business");
	}

	public static void main(String[] args) {
		SpringApplication.run(RecordShopRestServiceApplication.class, args);
	}

}
