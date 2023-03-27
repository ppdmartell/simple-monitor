package simplemonitor.camel.retriever.categories;

import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import simplemonitor.camel.retriever.model.entity.Category;

public class CategoryUtils {
	
	static Logger logger = LoggerFactory.getLogger(CategoryUtils.class);

	public static String getCategoryFromIndexName(String indexName) {
		return indexName.split("-")[0];
	}
	
	public static Category mapCategoryDtoToCategory(CategoryDto dto) {
		Category category = new Category();
		category.setHealth(dto.getHealth());
		category.setStatus(dto.getStatus());
		category.setIndice(dto.getIndice());
		category.setCategory(dto.getCategory());
		category.setUuid(dto.getUuid());
		category.setPri(dto.getPri());
		category.setRep(dto.getRep());
		category.setDocsCount(dto.getDocsCount());
		category.setDocsDeleted(dto.getDocsDeleted());
		category.setStoreSize(dto.getStoreSize());
		category.setPriStoreSize(dto.getPriStoreSize());

		return category;
	}
	
	public static CategoryDto mapCategoryToCategoryDto(Category category) {
		CategoryDto categoryDto = new CategoryDto();
		try {
			categoryDto.setHealth(category.getHealth());
			categoryDto.setStatus(category.getStatus());
			categoryDto.setIndice(category.getIndice());
			categoryDto.setCategory(category.getCategory());
			categoryDto.setUuid(category.getUuid());
			categoryDto.setPri(category.getPri());
			categoryDto.setRep(category.getRep());
			categoryDto.setDocsCount(category.getDocsCount());
			categoryDto.setDocsDeleted(category.getDocsDeleted());
			categoryDto.setStoreSize(category.getStoreSize());
			categoryDto.setPriStoreSize(category.getPriStoreSize());
			logger.info("mapCategoryToCategoryDto executed successfully.");
		} catch(Exception e) {
			logger.info(e.getMessage());
		}
		return categoryDto;
	}
	
}
