package simplemonitor.camel.retriever.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import simplemonitor.camel.retriever.model.dao.ICategoryDao;
import simplemonitor.camel.retriever.model.entity.Category;

@Service
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	ICategoryDao categoryDao;
	
	@Transactional(readOnly = true)
	@Override
	public Category getByUuid(String uuid) {
		return categoryDao.getByUuid(uuid);
	}

	@Override
	public void save(Category category) {
		categoryDao.save(category);
	}

	@Override
	public List<Category> findAll() {
		return (List<Category>) categoryDao.findAll();
	}

}
