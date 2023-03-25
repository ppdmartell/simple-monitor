package simplemonitor.camel.retriever.categories;

public class BootCategoryDto extends CategoryDto {

	public BootCategoryDto(String health, String status, String index, String category, String uuid, int pri, int rep,
			int docsCount, int docsDeleted, String storeSize, String priStoreSize) {
		super(health, status, index, category, uuid, pri, rep, docsCount, docsDeleted, storeSize, priStoreSize);
	}

}
