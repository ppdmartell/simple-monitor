package simplemonitor.camel.retriever.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "category")
public class Category implements Serializable {
	
	/*	health	"yellow"
		status	"open"
		index	"kernel-debian-one-2023.03.19"
		uuid	"-ChQQbXhREWXMEF_WXRfFw"
		pri	"1"
		rep	"1"
		docs.count	"1502"
		docs.deleted	"0"
		store.size	"560.7kb"
		pri.store.size	"560.7kb"*/
	
	/**
	 * 
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "health")
	private String health;
	
	@NotNull
	@Column(name = "status")
	private String status;
	
	@NotNull
	@Column(name = "indice")
	private String indice;
	
	@NotNull
	@Column(name = "category")
	private String category;
	
	@NotNull
	@Column(name = "uuid")
	private String uuid;
	
	@Column(name = "pri")
	private int pri;
	
	@Column(name = "rep")
	private int rep;
	
	@NotNull
	@Column(name = "docs_count")
	private int docsCount;
	
	@Column(name = "docs_deleted")
	private int docsDeleted;
	
	@Column(name = "store_size")
	private String storeSize;
	
	@Column(name = "pri_store_size")
	private String priStoreSize;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	private static final long serialVersionUID = 1L;

	public String getHealth() {
		return health;
	}

	public void setHealth(String health) {
		this.health = health;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIndice() {
		return indice;
	}

	public void setIndice(String indice) {
		this.indice = indice;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public int getPri() {
		return pri;
	}

	public void setPri(int pri) {
		this.pri = pri;
	}

	public int getRep() {
		return rep;
	}

	public void setRep(int rep) {
		this.rep = rep;
	}

	public int getDocsCount() {
		return docsCount;
	}

	public void setDocsCount(int docsCount) {
		this.docsCount = docsCount;
	}

	public int getDocsDeleted() {
		return docsDeleted;
	}

	public void setDocsDeleted(int docsDeleted) {
		this.docsDeleted = docsDeleted;
	}

	public String getStoreSize() {
		return storeSize;
	}

	public void setStoreSize(String storeSize) {
		this.storeSize = storeSize;
	}

	public String getPriStoreSize() {
		return priStoreSize;
	}

	public void setPriStoreSize(String priStoreSize) {
		this.priStoreSize = priStoreSize;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", health=" + health + ", status=" + status + ", indice=" + indice + ", category="
				+ category + ", uuid=" + uuid + ", pri=" + pri + ", rep=" + rep + ", docsCount=" + docsCount
				+ ", docsDeleted=" + docsDeleted + ", storeSize=" + storeSize + ", priStoreSize=" + priStoreSize + "]";
	}
	
}
