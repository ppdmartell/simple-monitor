package simplemonitor.camel.retriever.service;

import simplemonitor.camel.retriever.model.entity.Category;

public interface ICategoryService {

	public Category getByUuid(String uuid);
	public void save(Category category);
	
}
