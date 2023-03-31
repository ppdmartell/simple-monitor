package simplemonitor.microservice.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IndexCallDto {
	
	@JsonProperty("_shards")
	private ShardsDto shardsDto;
	
	private HitsDto hits;
	
	private int took;
	
	@JsonProperty("timed_out")
	private boolean timedOut;

	public int getTook() {
		return took;
	}

	public void setTook(int took) {
		this.took = took;
	}

	public boolean isTimedOut() {
		return timedOut;
	}

	public void setTimedOut(boolean timedOut) {
		this.timedOut = timedOut;
	}

	public ShardsDto getShardsDto() {
		return shardsDto;
	}

	public void setShardsDto(ShardsDto shardsDto) {
		this.shardsDto = shardsDto;
	}

	public HitsDto getHits() {
		return hits;
	}

	public void setHits(HitsDto hits) {
		this.hits = hits;
	}

	@Override
	public String toString() {
		return "IndexCallDto [took=" + took + ", timedOut=" + timedOut + ", shardsDto=" + shardsDto + ", hits=" + hits
				+ "]";
	}
	
}
