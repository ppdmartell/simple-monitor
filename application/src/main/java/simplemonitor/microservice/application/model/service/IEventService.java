package simplemonitor.microservice.application.model.service;

import java.util.List;

import simplemonitor.microservice.application.model.entity.Event;

public interface IEventService {
	
	public void save(Event event);
	public int getTotalEvents();
	public List<Event> findAllDateOrdered();
	public List<Event> getEventsByHostname(String hostname);
	public Object[] getHostInfo(String hostname);

}
