package io.denery.vadimbin;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootTest
class VadimbinApplicationTests {
	private static final Logger logger = LoggerFactory.getLogger("VadimBinTest");

	@Test
	void contextLoads() {
		WebClient webClient = WebClient.create("http://localhost:8080");

		String spam = "a".repeat(20001);

		/*
		webClient.post()
				.uri("/edit")
				.bodyValue(new Bin(spam))
				.exchangeToMono(res -> res.bodyToMono(Bin.class))
				.subscribe(bin -> logger.info("POST: " + bin.getStory()));
		 */
	}
}
