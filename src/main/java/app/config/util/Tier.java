package app.config.util;

import java.util.ArrayList;
import java.util.List;

public class Tier{
    private String name;
    private List<Tier> children = new ArrayList<>();
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Tier> getChildren() {
		return children;
	}
	public void setChildren(List<Tier> children) {
		this.children = children;
	}
    
    
}

