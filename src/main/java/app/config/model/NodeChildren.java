package app.config.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NODES_CHILDRENS")
public class NodeChildren {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer childrenId;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getChildrenId() {
		return childrenId;
	}
	public void setChildrenId(Integer childrenId) {
		this.childrenId = childrenId;
	}
	
	
	

	
	
}
