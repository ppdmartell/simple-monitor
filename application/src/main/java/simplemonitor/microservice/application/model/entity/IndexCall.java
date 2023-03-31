package simplemonitor.microservice.application.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "index_call")
public class IndexCall {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_shards_id", referencedColumnName = "id")
	private Shards shards;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_hits_id", referencedColumnName = "id")
	private Hits hits;
	
	@Column(name = "timed_out")
	private boolean timedOut;
	
	private int took;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Shards getShards() {
		return shards;
	}

	public void setShards(Shards shards) {
		this.shards = shards;
	}

	public Hits getHits() {
		return hits;
	}

	public void setHits(Hits hits) {
		this.hits = hits;
	}

	public boolean isTimedOut() {
		return timedOut;
	}

	public void setTimedOut(boolean timedOut) {
		this.timedOut = timedOut;
	}

	public int getTook() {
		return took;
	}

	public void setTook(int took) {
		this.took = took;
	}

	@Override
	public String toString() {
		return "IndexCall [id=" + id + ", shards=" + shards + ", hits=" + hits + ", timedOut=" + timedOut + ", took="
				+ took + "]";
	}
	
}
