package io.denery.vadimbin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VadimBinApplication {
	private static final Logger logger = LoggerFactory.getLogger("VadimBin");

	public static void main(String[] args) {
		logger.info("Starting VadimBin Server...");
		var context = SpringApplication.run(VadimBinApplication.class, args);
	}
}
