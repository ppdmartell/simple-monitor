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
@Table(name = "source")
public class Source {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_log_id", referencedColumnName = "id")
	private Log log;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_input_id", referencedColumnName = "id")
	private Input input;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_fields_id", referencedColumnName = "id")
	private Fields fields;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_agent_id", referencedColumnName = "id")
	private Agent agent;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_ecs_id", referencedColumnName = "id")
	private Ecs ecs;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_host_id", referencedColumnName = "id")
	private Host host;
	
	@ElementCollection
	@CollectionTable(name = "source_tags")
	@Column(name = "tag")
	private List<String> tags;
	
	private String timestamp;
	private String message;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Log getLog() {
		return log;
	}
	public void setLog(Log log) {
		this.log = log;
	}
	public Input getInput() {
		return input;
	}
	public void setInput(Input input) {
		this.input = input;
	}
	public Fields getFields() {
		return fields;
	}
	public void setFields(Fields fields) {
		this.fields = fields;
	}
	public Agent getAgent() {
		return agent;
	}
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	public Ecs getEcs() {
		return ecs;
	}
	public void setEcs(Ecs ecs) {
		this.ecs = ecs;
	}
	public Host getHost() {
		return host;
	}
	public void setHost(Host host) {
		this.host = host;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "Source [id=" + id + ", log=" + log + ", input=" + input + ", fields=" + fields + ", agent=" + agent
				+ ", ecs=" + ecs + ", host=" + host + ", tags=" + tags + ", timestamp=" + timestamp + ", message="
				+ message + "]";
	}
	
}
