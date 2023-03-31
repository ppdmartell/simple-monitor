package simplemonitor.microservice.application.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "agent")
public class Agent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "legacy_id")
	private String legacyId;
	
	private String name;
	private String type;
	private String version;
	
	@Column(name = "ephemeral_id")
	private String ephemeralId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Agent [id=" + id + ", legacyId=" + legacyId + ", name=" + name + ", type=" + type + ", version="
				+ version + ", ephemeralId=" + ephemeralId + "]";
	}
	
}
