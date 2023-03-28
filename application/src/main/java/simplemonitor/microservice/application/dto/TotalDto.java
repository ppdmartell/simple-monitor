package simplemonitor.microservice.application.dto;

public class TotalDto {
	
	private int value;
	private String relation;
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	@Override
	public String toString() {
		return "TotalDto [value=" + value + ", relation=" + relation + "]";
	}
	
}
