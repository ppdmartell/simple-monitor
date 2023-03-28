package simplemonitor.microservice.application.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HitsDto {
	
	private TotalDto total;
	
	@JsonProperty("max_score")
	private int maxScore;
	private List<HitDto> hits;
	
	public TotalDto getTotal() {
		return total;
	}
	public void setTotal(TotalDto total) {
		this.total = total;
	}
	public int getMaxScore() {
		return maxScore;
	}
	public void setMaxScore(int maxScore) {
		this.maxScore = maxScore;
	}
	public List<HitDto> getHits() {
		return hits;
	}
	public void setHits(List<HitDto> hits) {
		this.hits = hits;
	}
	@Override
	public String toString() {
		return "HitsDto [total=" + total + ", maxScore=" + maxScore + ", hits=" + hits + "]";
	}

}
