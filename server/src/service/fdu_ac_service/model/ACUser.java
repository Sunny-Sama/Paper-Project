package service.fdu_ac_service.model;

import javax.persistence.Column;  
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;  
import javax.persistence.Table;  

@Entity
@Table(name="bd_access_control_user")
public class ACUser {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column
	private long catalog_id;
	
	@Column
	private long user_id;
	
	@Column
	private int type;
	
	@Column
	private long hash;
	
	public ACUser(){}

	public ACUser(long catalog_id, long user_id, int type, long hash) {
		super();
		this.catalog_id = catalog_id;
		this.user_id = user_id;
		this.type = type;
		this.hash = hash;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCatalog_id() {
		return catalog_id;
	}

	public void setCatalog_id(long catalog_id) {
		this.catalog_id = catalog_id;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public long getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public long getHash() {
		return hash;
	}

	public void setHash(long hash) {
		this.hash = hash;
	}
}
