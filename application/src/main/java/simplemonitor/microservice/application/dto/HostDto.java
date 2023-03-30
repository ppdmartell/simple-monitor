package simplemonitor.microservice.application.dto;

import java.util.List;

public class HostDto {
	
	private OsDto os;
	private String architecture;
	private String legacyId;
	private String name;
	private boolean containerized;
	private List<String> ip;
	private List<String> mac;
	private String hostname;
	
	public String getArchitecture() {
		return architecture;
	}
	public void setArchitecture(String architecture) {
		this.architecture = architecture;
	}
	public OsDto getOs() {
		return os;
	}
	public void setOs(OsDto os) {
		this.os = os;
	}
	public String getLegacyId() {
		return legacyId;
	}
	public void setLegacyId(String legacyId) {
		this.legacyId = legacyId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isContainerized() {
		return containerized;
	}
	public void setContainerized(boolean containerized) {
		this.containerized = containerized;
	}
	public List<String> getIp() {
		return ip;
	}
	public void setIp(List<String> ip) {
		this.ip = ip;
	}
	public List<String> getMac() {
		return mac;
	}
	public void setMac(List<String> mac) {
		this.mac = mac;
	}
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	
	@Override
	public String toString() {
		return "HostDto [architecture=" + architecture + ", os=" + os + ", legacyId=" + legacyId + ", name=" + name
				+ ", containerized=" + containerized + ", ip=" + ip + ", mac=" + mac + ", hostname=" + hostname + "]";
	}
	
}
