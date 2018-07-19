package app.config.util;



import java.util.ArrayList;
import java.util.List;

public class Tier {
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

    public void setChildrenList(List<String> children) {
        for(String child: children){
            Tier localTier = new Tier();
            localTier.setName(child);
            this.children.add(localTier);
        }
    }

    public boolean hasChildren() {
        return children.size()>0;
    }
}


