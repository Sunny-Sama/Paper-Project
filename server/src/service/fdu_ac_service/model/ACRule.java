package service.fdu_ac_service.model;

import javax.persistence.Column;  
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;  
import javax.persistence.Table;  

@Entity
@Table(name="bd_ac_rule_table")
public class ACRule {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column
	private long rule_id;
	
	@Column
	private long table_id;

	public long getId() {
		return id;
	}
	
	public ACRule() {}

	public ACRule(long rule_id, long table_id) {
		super();
		this.rule_id = rule_id;
		this.table_id = table_id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getRule_id() {
		return rule_id;
	}

	public void setRule_id(long rule_id) {
		this.rule_id = rule_id;
	}

	public long getTable_id() {
		return table_id;
	}

	public void setTable_id(long table_id) {
		this.table_id = table_id;
	}
}
