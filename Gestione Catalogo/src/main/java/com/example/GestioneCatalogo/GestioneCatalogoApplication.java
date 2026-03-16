package com.example.GestioneCatalogo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class GestioneCatalogoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestioneCatalogoApplication.class, args);
	}

}
