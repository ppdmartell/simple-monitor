package simplemonitor.camel.retriever.categories;

public class CategoryDto {
	
	private String health;
	private String status;
	private String indice;
	private String category;
	private String uuid;
	private int pri;
	private int rep;
	private int docsCount;
	private int docsDeleted;
	private String storeSize;
	private String priStoreSize;
	
	public CategoryDto() {}
	
	public CategoryDto(String health, String status, String indice, String category, String uuid, int pri, int rep,
			int docsCount, int docsDeleted, String storeSize, String priStoreSize) {
		super();
		this.health = health;
		this.status = status;
		this.indice = indice;
		this.category = category;
		this.uuid = uuid;
		this.pri = pri;
		this.rep = rep;
		this.docsCount = docsCount;
		this.docsDeleted = docsDeleted;
		this.storeSize = storeSize;
		this.priStoreSize = priStoreSize;
	}
	public String getHealth() {
		return health;
	}
	public void setHealth(String health) {
		this.health = health;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getIndice() {
		return indice;
	}
	public void setIndice(String indice) {
		this.indice = indice;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public int getPri() {
		return pri;
	}
	public void setPri(int pri) {
		this.pri = pri;
	}
	public int getRep() {
		return rep;
	}
	public void setRep(int rep) {
		this.rep = rep;
	}
	public int getDocsCount() {
		return docsCount;
	}
	public void setDocsCount(int docsCount) {
		this.docsCount = docsCount;
	}
	public int getDocsDeleted() {
		return docsDeleted;
	}
	public void setDocsDeleted(int docsDeleted) {
		this.docsDeleted = docsDeleted;
	}
	public String getStoreSize() {
		return storeSize;
	}
	public void setStoreSize(String storeSize) {
		this.storeSize = storeSize;
	}
	public String getPriStoreSize() {
		return priStoreSize;
	}
	public void setPriStoreSize(String priStoreSize) {
		this.priStoreSize = priStoreSize;
	}

	@Override
	public String toString() {
		return this.getClass() + " [health=" + health + ", status=" + status + ", indice=" + indice + ", category=" + category
				+ ", uuid=" + uuid + ", pri=" + pri + ", rep=" + rep + ", docsCount=" + docsCount + ", docsDeleted="
				+ docsDeleted + ", storeSize=" + storeSize + ", priStoreSize=" + priStoreSize + "]";
	}

	

}
