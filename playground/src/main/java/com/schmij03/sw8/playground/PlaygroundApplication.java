package com.schmij03.sw8.playground;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class PlaygroundApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlaygroundApplication.class, args);
	}

	@RestController
	public class SentimentController {

		@GetMapping("/ping")
		public String ping() {
			return "Sentiment app is up and running!";
		}

		@GetMapping("/count")
		public int count() {
			return 42;
		}
	}
}
