package com.BallenaRuiz.infraccionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ExamenBallenaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamenBallenaApplication.class, args);
	}

}
