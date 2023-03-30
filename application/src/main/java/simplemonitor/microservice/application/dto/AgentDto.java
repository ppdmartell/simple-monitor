package simplemonitor.microservice.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AgentDto {
	
	private String name;
	private String type;
	private String version;
	
	@JsonProperty("ephemeral_id")
	private String ephemeralId;
	private String legacyId;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getEphemeralId() {
		return ephemeralId;
	}
	public void setEphemeralId(String ephemeralId) {
		this.ephemeralId = ephemeralId;
	}
	public String getLegacyId() {
		return legacyId;
	}
	public void setLegacyId(String legacyId) {
		this.legacyId = legacyId;
	}
	@Override
	public String toString() {
		return "AgentDto [name=" + name + ", type=" + type + ", version=" + version + ", ephemeralId=" + ephemeralId
				+ ", legacyId=" + legacyId + "]";
	}
	
}
