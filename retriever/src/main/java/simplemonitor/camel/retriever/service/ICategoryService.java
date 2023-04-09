package simplemonitor.camel.retriever.service;

import java.util.List;

import simplemonitor.camel.retriever.model.entity.Category;

public interface ICategoryService {

	public Category getByUuid(String uuid);
	public void save(Category category);
	public List<Category> findAll();
	
}
