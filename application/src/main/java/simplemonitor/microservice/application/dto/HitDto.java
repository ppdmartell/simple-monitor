package simplemonitor.microservice.application.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HitDto {
	
	@JsonProperty("_index")
	private String index;
	
	@JsonProperty("_id")
	private String id;
	
	@JsonProperty("_score")
	private int score;
	
	@JsonProperty("_source")
	private SourceDto source;
	
	@JsonProperty("_ignored")
	private List<String> ignored;

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public SourceDto getSource() {
		return source;
	}

	public void setSource(SourceDto source) {
		this.source = source;
	}

	public List<String> getIgnored() {
		return ignored;
	}

	public void setIgnored(List<String> ignored) {
		this.ignored = ignored;
	}

	@Override
	public String toString() {
		return "HitDto [index=" + index + ", id=" + id + ", score=" + score + ", source=" + source + ", ignored="
				+ ignored + "]";
	}
	
}
