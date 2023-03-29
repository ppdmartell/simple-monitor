package simplemonitor.microservice.application.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import simplemonitor.microservice.application.Constants;
import simplemonitor.microservice.application.dto.CategoryDto;
import simplemonitor.microservice.application.dto.IndexCallDto;

@RestController
@RequestMapping("/api/category")
public class ApplicationController {
	
	@Autowired
	WebClient.Builder webClientBuilder;
	
	Logger logger = LoggerFactory.getLogger(ApplicationController.class);
	
	/**
	 * This method is the entry point of the microservice.
	 * it receives the POST API call from the retriever and
	 * since it deals with Application category, will try to get
	 * application-type logs from elasticsearch and process them.
	 * @param categoryDto
	 * @return
	 */
	@PostMapping("/application")
	public ResponseEntity<String> receiveCategoryDto(@Valid @RequestBody CategoryDto categoryDto) {
		logger.info("Received a CategoryDto object: " + categoryDto.toString());
		String uri = Constants.PROTOCOL
				+ Constants.REMOTE_HOST
				+ Constants.PORT
				+ categoryDto.getIndice()
				+ Constants.QUERY_SEARCH;
		logger.info("URI (" + uri + ")");
		try {
			IndexCallDto responseIndexCallDto = webClientBuilder.build()
						.get()
						.uri(uri)
						.retrieve()
						.bodyToMono(IndexCallDto.class)
						.block();
			logger.info("RESPONSE CALL: " + responseIndexCallDto.toString());
		} catch(Exception e) {
			logger.info("The JSON index data for " + categoryDto.getIndice()
			          + " couldn't be retrieved. Error: " + e.getMessage());
		}
		return ResponseEntity.ok(categoryDto.toString());
	}

}
