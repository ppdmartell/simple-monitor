package simplemonitor.microservice.application.dto;

public class ShardsDto {
	
	private int total;
	private int successful;
	private int skipped;
	private int failed;
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getSuccessful() {
		return successful;
	}
	public void setSuccessful(int successful) {
		this.successful = successful;
	}
	public int getSkipped() {
		return skipped;
	}
	public void setSkipped(int skipped) {
		this.skipped = skipped;
	}
	public int getFailed() {
		return failed;
	}
	public void setFailed(int failed) {
		this.failed = failed;
	}
	@Override
	public String toString() {
		return "ShardsDto [total=" + total + ", successful=" + successful + ", skipped=" + skipped + ", failed="
				+ failed + "]";
	}
	
}
