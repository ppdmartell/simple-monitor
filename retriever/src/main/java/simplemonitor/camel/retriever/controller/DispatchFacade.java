package simplemonitor.camel.retriever.controller;

import java.util.LinkedList;

import org.hibernate.ObjectNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import simplemonitor.camel.retriever.categories.CategoryDto;
import simplemonitor.camel.retriever.categories.CategoryUtils;
import simplemonitor.camel.retriever.dispatchers.ApplicationDispatcher;
import simplemonitor.camel.retriever.dispatchers.BootDispatcher;
import simplemonitor.camel.retriever.dispatchers.Dispatcher;
import simplemonitor.camel.retriever.dispatchers.HardwareDispatcher;
import simplemonitor.camel.retriever.dispatchers.KernelDispatcher;
import simplemonitor.camel.retriever.dispatchers.SecurityDispatcher;
import simplemonitor.camel.retriever.dispatchers.UserDispatcher;
import simplemonitor.camel.retriever.model.dao.ICategoryDao;
import simplemonitor.camel.retriever.model.entity.Category;

@Component
public class DispatchFacade {
	
	@Autowired
	ICategoryDao categoryService;
	
	private Logger logger = LoggerFactory.getLogger(DispatchFacade.class);
	
	/**
	 * If it is a new index, persist it
	 * or else modify the existing one and update it
	 * in the database. Then start the dispatching
	 * process in any case.
	 * @param category
	 */
	public void process(CategoryDto category) {
		Category categoryFound = categoryService.getByUuid(category.getUuid());
		if(categoryFound == null) {
			categoryService.save(CategoryUtils.mapCategoryDtoToCategory(category));
			dispatch(categoryFound);
		}
		else {
			ifDiffUpdateAndDispatch(category, categoryFound);
		}
	}
	
	private void ifDiffUpdateAndDispatch(CategoryDto modified, Category old) {
		boolean updated = false;
		if(modified.getDocsCount() > old.getDocsCount()) {
			old.setDocsCount(modified.getDocsCount());
			updated = true;
		}
		if(modified.getDocsDeleted() > old.getDocsDeleted()) {
			old.setDocsDeleted(modified.getDocsDeleted());
			updated = true;
		}
		if(!modified.getStoreSize().equals(old.getStoreSize())) {
			old.setStoreSize(modified.getStoreSize());
			updated = true;
		}
		if(!modified.getPriStoreSize().equals(old.getPriStoreSize())) {
			old.setPriStoreSize(modified.getPriStoreSize());
			updated = true;
		}
		if(updated) {
			categoryService.save(old);
			dispatch(old);
		}
	}
	
	/**
	 * Since there are different categories (the same amount
	 * of microservices dedicating to dispatch) it depends
	 * on the type in order to select the proper dispatcher.
	 * @param category
	 */
	void dispatch(Category category) {
		Dispatcher dispatcher;
		if(category.getCategory().equals("boot")) {
			dispatcher = new BootDispatcher();
			dispatcher.dispatch(CategoryUtils.mapCategoryToCategoryDto(category));
			return;
		}
		
		if(category.getCategory().equals("kernel")) {
			dispatcher = new KernelDispatcher();
			dispatcher.dispatch(CategoryUtils.mapCategoryToCategoryDto(category));
			return;
		}
		
		if(category.getCategory().equals("application")) {
			dispatcher = new ApplicationDispatcher();
			dispatcher.dispatch(CategoryUtils.mapCategoryToCategoryDto(category));
			return;
		}
		
		if(category.getCategory().equals("security")) {
			dispatcher = new SecurityDispatcher();
			dispatcher.dispatch(CategoryUtils.mapCategoryToCategoryDto(category));
			return;
		}
		
		if(category.getCategory().equals("hardware")) {
			dispatcher = new HardwareDispatcher();
			dispatcher.dispatch(CategoryUtils.mapCategoryToCategoryDto(category));
			return;
		}
		
		if(category.getCategory().equals("user")) {
			dispatcher = new UserDispatcher();
			dispatcher.dispatch(CategoryUtils.mapCategoryToCategoryDto(category));
			return;
		}
	}
}
