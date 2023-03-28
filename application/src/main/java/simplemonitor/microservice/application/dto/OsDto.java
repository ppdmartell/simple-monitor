package simplemonitor.microservice.application.dto;

public class OsDto {
	
	private String codename;
	private String type;
	private String platform;
	private String version;
	private String family;
	private String name;
	private String kernel;
	
	public String getCodename() {
		return codename;
	}
	public void setCodename(String codename) {
		this.codename = codename;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getFamily() {
		return family;
	}
	public void setFamily(String family) {
		this.family = family;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKernel() {
		return kernel;
	}
	public void setKernel(String kernel) {
		this.kernel = kernel;
	}
	
	@Override
	public String toString() {
		return "OsDto [codename=" + codename + ", type=" + type + ", platform=" + platform + ", version=" + version
				+ ", family=" + family + ", name=" + name + ", kernel=" + kernel + "]";
	}
	
	

}
