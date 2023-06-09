package simplemonitor.microservice.application.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hit")
public class Hit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_hits_id", referencedColumnName = "id")
	private Hits hits;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_source_id", referencedColumnName = "id")
	private Source source;
	
	@Column(name = "index_name")
	private String indexName;
	
	@Column(name = "legacy_id")
	private String legacyId;
	
	@ElementCollection
	@CollectionTable(name = "hit_ignored")
	@Column(name = "ignored")
	private List<String> ignored;
	
	private int score;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Hits getHits() {
		return hits;
	}

	public void setHits(Hits hits) {
		this.hits = hits;
	}

	public Source getSource() {
		return source;
	}

	public void setSource(Source source) {
		this.source = source;
	}

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

	public List<String> getIgnored() {
		return ignored;
	}

	public void setIgnored(List<String> ignored) {
		this.ignored = ignored;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
