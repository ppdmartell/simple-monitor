package simplemonitor.microservice.application.dto;

public class FileDto {
	
	private String path;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "FileDto [path=" + path + "]";
	}
	
}
