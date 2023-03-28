package simplemonitor.microservice.application.dto;

public class EcsDto {
	
	private String version;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "EcsDto [version=" + version + "]";
	}

}
