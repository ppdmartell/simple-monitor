package simplemonitor.microservice.application.dto;

public class InputDto {
	
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "InputDto [type=" + type + "]";
	}
	
}
