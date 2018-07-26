package app.config.dto;

import java.util.List;

public class ReceiveNode {

	private String nodeId;
	private String nodeName;
	private String nodeFather;
	private List<Object> childrens;

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

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
		return "ReceiveNode [nodeId=" + nodeId + ", nodeName=" + nodeName + ", nodeFather=" + nodeFather
				+ ", childrens=" + childrens + "]";
	}

}
