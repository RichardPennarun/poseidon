package com.poseidon.API;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class PoseidonApiApplication {

	private static final Logger logger = LogManager.getLogger(PoseidonApiApplication.class);

	public static void main(String[] args) {
		logger.info("Initializing Poseidon API");
		SpringApplication.run(PoseidonApiApplication.class, args);
	}

}
