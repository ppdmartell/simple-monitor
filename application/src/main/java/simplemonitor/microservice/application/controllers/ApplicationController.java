package simplemonitor.microservice.application.controllers;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import simplemonitor.microservice.application.Constants;
import simplemonitor.microservice.application.EventMapper;
import simplemonitor.microservice.application.IndexMapper;
import simplemonitor.microservice.application.dto.CategoryDto;
import simplemonitor.microservice.application.dto.IndexCallDto;
import simplemonitor.microservice.application.model.entity.Event;
import simplemonitor.microservice.application.model.entity.Hit;
import simplemonitor.microservice.application.model.entity.IndexCall;
import simplemonitor.microservice.application.model.service.IEventService;
import simplemonitor.microservice.application.model.service.IIndexCallService;

@RestController
@RequestMapping("/api/category")
public class ApplicationController {
	
	@Autowired
	WebClient.Builder webClientBuilder;
	
	@Autowired
	IIndexCallService indexCallService;
	
	@Autowired
	IndexMapper indexMapper;
	
	@Autowired
	IEventService eventService;
	
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
		IndexCallDto responseIndexCallDto = new IndexCallDto();
		logger.info("Received a CategoryDto object: " + categoryDto.toString());
		String uri = Constants.PROTOCOL
				+ Constants.REMOTE_HOST
				+ Constants.PORT
				+ categoryDto.getIndice()
				+ Constants.QUERY_SEARCH;
		logger.info("URI (" + uri + ")");
		
		try {
			responseIndexCallDto = webClientBuilder.build()
						.get()
						.uri(uri)
						.retrieve()
						.bodyToMono(IndexCallDto.class)
						.block();
			logger.info("RESPONSE CALL: " + responseIndexCallDto.toString());
		} catch(Exception e) {
			logger.info("The JSON index data for " + categoryDto.getIndice()
			          + " couldn't be retrieved. Error: " + e.getMessage()
			          + "\nException class: " + e.getClass().getName());
			return ResponseEntity.ok("Remote APPLICATION host: Problems retrieving data from elasticsearch.");
		}
		final IndexCallDto newIndexCallDto = responseIndexCallDto;
		logger.info("BEFORE thread");
		new Thread(() -> this.processDto(newIndexCallDto)).start();
		return ResponseEntity.ok(categoryDto.toString());
	}
	
	/**
	 * This method receives an IndexCallDto type param
	 * and then uses MapStruct to perform a DTO-to-Entity mapping
	 * and finally it tries to persist this object in the database
	 * @param indexCallDto
	 */
	void processDto(IndexCallDto indexCallDto) {
		if(indexCallDto != null) {
			try {
				//TODO Try to do the mapping manual to understand more.
				//IndexCall indexCall = IndexCallMapper.INSTANCE.toEntity(indexCallDto);
				//logger.info("MAPPING PERFORMED WITHOUT ERRORS: " + indexCall.toString());
				IndexCall indexCall = indexMapper.mapIndexDtoToEntity(indexCallDto);
				indexCallService.save(indexCall);
				this.persistEvents(indexCall.getHits().getHits());
				logger.info("DATA PERSISTED");
			} catch(Exception e) {
				logger.info("Exception type: " + e.getClass().getName()
						  + " MAPPER error: " + e.getMessage());
			}
		}
		else logger.info("The object of type IndexCallDto was null.");
	}
	
	public void persistEvents(List<Hit> hits) {
		Event event = new Event();
		for(Hit hit : hits) {
			try {
				event = EventMapper.populateEvent(hit);
				eventService.save(event);
			}
			catch(Exception e) {
				logger.info("ERROR PERSISTING EVENT: " + e.getMessage()
				           + ". CLASS EXCEPTION: " + e.getClass().getName());
			}
		}
	}
	
	/**
	 * Returns the amount of application-type events in the events table
	 * @return
	 */
	@GetMapping("/application/events/total")
	public int getTotalEvents() {
		return eventService.getTotalEvents();
	}
	
	/**
	 * Returns ALL the events ordered by date, from first to last
	 * from every host combined
	 * @return
	 */
	@GetMapping("/application/events")
	public List<Event> getEvents() {
		return eventService.findAllDateOrdered();
	}

	/**
	 * Returns a list of events for only a host, specified the name
	 * as a parameter
	 * @param hostname
	 * @return
	 */
	@GetMapping("/application/events/host/{hostname}")
	public List<Event> getEventsByHostname(@PathVariable String hostname) {
		return eventService.getEventsByHostname(hostname);
	}
	
	/**
	 * Returns the amount of application-based events
	 * for a certain host, specified the name as a parameter
	 * @param hostname
	 * @return
	 */
	@GetMapping("/application/events/amount/host/{hostname}")
	public int getAmountEventsByHostname(@PathVariable String hostname) {
		return this.getEventsByHostname(hostname).size();
	}
	
	/**
	 * Returns the registered attributes for a host specified as a parameter
	 * @param hostname
	 * @return
	 */
	@GetMapping("/application/info/host/{hostname}")
	public Object[] getHostInfo(@PathVariable String hostname) {
		return eventService.getHostInfo(hostname);
	}

}
