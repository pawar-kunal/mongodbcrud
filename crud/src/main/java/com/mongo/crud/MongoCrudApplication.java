package com.mongo.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongoCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoCrudApplication.class, args);
		System.out.println("MONGO CRUD");
	}

}
