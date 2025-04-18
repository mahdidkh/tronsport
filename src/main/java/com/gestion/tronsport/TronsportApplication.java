package com.gestion.tronsport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.gestion.tronsport.entity")
@EnableJpaRepositories("com.gestion.tronsport.repository")
public class TronsportApplication {

	public static void main(String[] args) {
		SpringApplication.run(TronsportApplication.class, args);
	}

}

