package simplemonitor.microservice.application.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import simplemonitor.microservice.application.model.entity.Event;

public interface IEventDao extends JpaRepository<Event, Long> {
	
	@Query("SELECT e FROM Event e WHERE e.legacyId = ?1")
	public Event findByLegacyId(String legacyId);
	
	@Query("SELECT COUNT(*) FROM Event e")
	public int getTotalEvents();
	
	@Query("SELECT e FROM Event e ORDER BY e.datetime ASC")
	public List<Event> findAllDateOrdered();
	
	@Query("SELECT e FROM Event e WHERE e.hostname = ?1 ORDER BY e.datetime ASC")
	public List<Event> getEventsByHostname(String hostname);
	
	@Query("SELECT e.hostname, e.ip, e.mac, e.architecture, e.osName, e.kernel, e.osType, e.osVersion"
		 + " FROM Event e WHERE e.hostname = ?1"
		 + " GROUP BY e.hostname, e.ip, e.mac, e.architecture, e.osName, e.kernel, e.osType, e.osVersion")
	public Object[] getHostInfo(String hostname);

}
