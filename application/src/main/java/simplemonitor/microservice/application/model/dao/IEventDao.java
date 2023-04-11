package simplemonitor.microservice.application.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import simplemonitor.microservice.application.model.entity.Event;

public interface IEventDao extends JpaRepository<Event, Long> {
	
	@Query("SELECT e FROM Event e WHERE e.legacyId = ?1 ")
	public Event findByLegacyId(String legacyId);
	
	@Query("SELECT COUNT(*) FROM Event e")
	public int getTotalEvents();

}
