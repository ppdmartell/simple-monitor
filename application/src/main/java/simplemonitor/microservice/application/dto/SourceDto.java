package simplemonitor.microservice.application.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SourceDto {
	
	private LogDto log;
	private InputDto input;
	private FieldsDto fields;
	private AgentDto agent;
	private EcsDto ecs;
	private HostDto host;
	
	@JsonProperty("@timestamp")
	private String timestamp;
	private String message;
	private List<String> tags;
	
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public LogDto getLog() {
		return log;
	}
	public void setLog(LogDto log) {
		this.log = log;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	public InputDto getInput() {
		return input;
	}
	public void setInput(InputDto input) {
		this.input = input;
	}
	public FieldsDto getFields() {
		return fields;
	}
	public void setFields(FieldsDto fields) {
		this.fields = fields;
	}
	public AgentDto getAgent() {
		return agent;
	}
	public void setAgent(AgentDto agent) {
		this.agent = agent;
	}
	public EcsDto getEcs() {
		return ecs;
	}
	public void setEcs(EcsDto ecs) {
		this.ecs = ecs;
	}
	public HostDto getHost() {
		return host;
	}
	public void setHost(HostDto host) {
		this.host = host;
	}
	@Override
	public String toString() {
		return "SourceDto [timestamp=" + timestamp + ", log=" + log + ", message=" + message + ", tags=" + tags
				+ ", input=" + input + ", fields=" + fields + ", agent=" + agent + ", ecs=" + ecs + ", host=" + host
				+ "]";
	}

	
}
