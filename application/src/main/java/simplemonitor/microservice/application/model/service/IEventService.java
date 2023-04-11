package simplemonitor.microservice.application.model.service;

import simplemonitor.microservice.application.model.entity.Event;

public interface IEventService {
	
	public void save(Event event);
	public int getTotalEvents();

}
