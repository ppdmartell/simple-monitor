package simplemonitor.microservice.application.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import simplemonitor.microservice.application.model.dao.IEventDao;
import simplemonitor.microservice.application.model.entity.Event;

@Service
public class EventServiceImpl implements IEventService {
	
	@Autowired
	private IEventDao eventDao;

	@Override
	public void save(Event event) {
		if(eventDao.findByLegacyId(event.getLegacyId()) == null)
			eventDao.save(event);
	}

	@Override
	public int getTotalEvents() {
		return eventDao.getTotalEvents();
	}
	
}
