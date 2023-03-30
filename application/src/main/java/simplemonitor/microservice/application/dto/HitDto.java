package simplemonitor.microservice.application.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HitDto {
	
	@JsonProperty("_source")
	private SourceDto source;
	
	@JsonProperty("_index")
	private String indexName;
	
	@JsonProperty("_id")
	private String legacyId;
	
	@JsonProperty("_score")
	private int score;
	
	@JsonProperty("_ignored")
	private List<String> ignored;

	public String getIndexName() {
		return indexName;
	}

	public void setIndexName(String indexName) {
		this.indexName = indexName;
	}

	public String getLegacyId() {
		return legacyId;
	}

	public void setLegacyId(String legacyId) {
		this.legacyId = legacyId;
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
		return "HitDto [indexName=" + indexName + ", legacyId=" + legacyId + ", score=" + score + ", source=" + source + ", ignored="
				+ ignored + "]";
	}
	
}
