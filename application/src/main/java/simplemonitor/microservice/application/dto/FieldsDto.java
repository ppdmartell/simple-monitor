package simplemonitor.microservice.application.dto;

public class FieldsDto {
	
	private String node;
	private String category;
	
	public String getNode() {
		return node;
	}
	public void setNode(String node) {
		this.node = node;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "FieldsDto [node=" + node + ", category=" + category + "]";
	}
	
}
