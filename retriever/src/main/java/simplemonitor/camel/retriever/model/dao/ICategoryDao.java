package simplemonitor.camel.retriever.model.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import simplemonitor.camel.retriever.model.entity.Category;

public interface ICategoryDao extends CrudRepository<Category, Long> {
	
	@Query("SELECT c FROM Category c WHERE c.uuid = ?1")
	public Category getByUuid(String uuid);

}
