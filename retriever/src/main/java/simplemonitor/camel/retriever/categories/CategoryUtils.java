package simplemonitor.camel.retriever.categories;

import java.util.regex.Pattern;

import simplemonitor.camel.retriever.model.entity.Category;

public class CategoryUtils {

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

		return categoryDto;
	}
	
}
