package simplemonitor.microservice.application.dto;

public class LogDto {
	
	private int offset;
	private FileDto file;
	
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public FileDto getFile() {
		return file;
	}
	public void setFile(FileDto file) {
		this.file = file;
	}
	@Override
	public String toString() {
		return "LogDto [offset=" + offset + ", file=" + file + "]";
	}
	
}
