package app.config.model;

import java.util.List;

public class ReceiveNode {

	private String nodeName;
	private List<Object> childrens;

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public List<Object> getChildrens() {
		return childrens;
	}

	public void setChildrens(List<Object> childrens) {
		this.childrens = childrens;
	}

}
