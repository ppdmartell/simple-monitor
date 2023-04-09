package simplemonitor.camel.retriever.restdto;

import java.util.List;

import org.springframework.stereotype.Component;

import simplemonitor.camel.retriever.model.entity.Category;

@Component
public class TotalIndexesDto {
	
	private String description;
	private List<Category> indices;
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<Category> getIndices() {
		return indices;
	}
	
	public void setIndices(List<Category> indices) {
		this.indices = indices;
	}
	
	@Override
	public String toString() {
		return "TotalIndexesDto [description=" + description + ", indices=" + indices + "]";
	}
}
