package simplemonitor.microservice.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class Application {
	
	@Bean
	public WebClient.Builder getBuilder() {
		return WebClient.builder();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
