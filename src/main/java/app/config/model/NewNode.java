package app.config.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class NewNode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nodeName;
	
//	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
//	@JoinColumn(name = "node_id")
//	private List<NodeChildren> childrens;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNodeName() {
		return nodeName;
	}
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
//	
//	public List<NodeChildren> getChildrens() {
//		return childrens;
//	}
//	public void setChildrens(List<NodeChildren> childrens) {
//		this.childrens = childrens;
//	}
//	@Override
//	public String toString() {
//		return "ReceiveNode [id=" + id + ", nodeName=" + nodeName + ", childrens=" + childrens + "]";
//	}
	
	
}
