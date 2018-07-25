package app.config.dto;

import java.util.List;

public class ReceiveNode {

	private String nodeName;
	private String nodeFather;
	private List<Object> childrens;
	
	public String getNodeName() {
		return nodeName;
	}
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	public String getNodeFather() {
		return nodeFather;
	}
	public void setNodeFather(String nodeFather) {
		this.nodeFather = nodeFather;
	}
	public List<Object> getChildrens() {
		return childrens;
	}
	public void setChildrens(List<Object> childrens) {
		this.childrens = childrens;
	}
	@Override
	public String toString() {
		return "ReceiveNode [nodeName=" + nodeName + ", nodeFather=" + nodeFather + ", childrens=" + childrens + "]";
	}

	

}
