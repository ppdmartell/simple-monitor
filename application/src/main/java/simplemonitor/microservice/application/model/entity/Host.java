package simplemonitor.microservice.application.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "host")
public class Host {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_os_id", referencedColumnName = "id")
	private Os os;
	
	@ElementCollection
	@CollectionTable(name = "host_ips")
	@Column(name = "ip_address")
	private List<String> ip;
	
	@ElementCollection
	@CollectionTable(name = "host_macs")
	@Column(name = "mac_address")
	private List<String> mac;
	
	private String architecture;
	
	@Column(name = "legacy_id")
	private String legacyId;
	
	private String name;
	private boolean containerized;
	private String hostname;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Os getOs() {
		return os;
	}
	public void setOs(Os os) {
		this.os = os;
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
	public String getArchitecture() {
		return architecture;
	}
	public void setArchitecture(String architecture) {
		this.architecture = architecture;
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
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	@Override
	public String toString() {
		return "Host [id=" + id + ", os=" + os + ", ip=" + ip + ", mac=" + mac + ", architecture=" + architecture
				+ ", legacyId=" + legacyId + ", name=" + name + ", containerized=" + containerized + ", hostname="
				+ hostname + "]";
	}
	
}
