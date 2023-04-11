package simplemonitor.microservice.application.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "events")
public class Event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "legacy_id")
	private String legacyId;
	
	@Column(name = "index_name")
	private String indexName;
	
	private String category;
	private String hostname;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date datetime;
	
	@Column(name = "log_files")
	private String logFiles;
	
	private String message;
	private String ip;
	private String mac;
	private String architecture;
	
	@Column(name = "os_name")
	private String osName;
	
	private String kernel;
	
	@Column(name = "os_type")
	private String osType;
	
	@Column(name = "os_version")
	private String osVersion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIndexName() {
		return indexName;
	}

	public void setIndexName(String indexName) {
		this.indexName = indexName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public String getLogFiles() {
		return logFiles;
	}

	public void setLogFiles(String logFiles) {
		this.logFiles = logFiles;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getArchitecture() {
		return architecture;
	}

	public void setArchitecture(String architecture) {
		this.architecture = architecture;
	}

	public String getOsName() {
		return osName;
	}

	public void setOsName(String osName) {
		this.osName = osName;
	}

	public String getKernel() {
		return kernel;
	}

	public void setKernel(String kernel) {
		this.kernel = kernel;
	}

	public String getOsType() {
		return osType;
	}

	public void setOsType(String osType) {
		this.osType = osType;
	}

	public String getOsVersion() {
		return osVersion;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}
	
	public String getLegacyId() {
		return legacyId;
	}

	public void setLegacyId(String legacyId) {
		this.legacyId = legacyId;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", legacyId=" + legacyId + ", indexName=" + indexName + ", category=" + category
				+ ", hostname=" + hostname + ", datetime=" + datetime + ", logFiles=" + logFiles + ", message="
				+ message + ", ip=" + ip + ", mac=" + mac + ", architecture=" + architecture + ", osName=" + osName
				+ ", kernel=" + kernel + ", osType=" + osType + ", osVersion=" + osVersion + "]";
	}

}
