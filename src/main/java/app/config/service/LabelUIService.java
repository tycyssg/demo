package app.config.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.config.model.LabelUI;
import app.config.repository.LabelUIRepository;
import app.config.util.Tier;

@Service
public class LabelUIService {

	@Autowired
	private LabelUIRepository labelUiRep;
	
	static List<Tier> menuItems = new ArrayList<>();
	
	public void addModuleUiLabel(String creator,String friendlyName,String parentName) {
		LabelUI laelUi = new LabelUI();
		laelUi.setCreator(creator);
		laelUi.setFriendlyName(friendlyName);
		laelUi.setParentLabel(parentName);
		laelUi.setObjectType(null);
		labelUiRep.save(laelUi);
	}
	
	
	public void createModuleLabelUi(HttpServletRequest request) {
		List<LabelUI> allUis =   labelUiRep.findAll();
		List<String> childName = new ArrayList<>();
		
		Map<String,List<String>> moduleUiMap = new LinkedHashMap<String, List<String>>();

		for(int i = 0;i < allUis.size();i++) {
				List<LabelUI> childList =  labelUiRep.findByParentLabel(allUis.get(i).getParentLabel());
				childName = new ArrayList<>();
				for(LabelUI mUi : childList) {
					childName.add(mUi.getFriendlyName());
				}
				moduleUiMap.put(allUis.get(i).getParentLabel(), childName);

		System.out.println(moduleUiMap.toString());		
		}

		transformToListOfObjects(moduleUiMap);

		StringBuilder allHtml = new StringBuilder(" <ul class='nav '>");
		for(Tier curentItem: menuItems){
			allHtml.append(run_recursion(curentItem));
		}
		allHtml.append("</ul>");
		 
		request.setAttribute("labelsDisplay",allHtml);
	}
	
	public boolean wasEntryAddedToExistingChildren(Tier path, Map.Entry<String, List<String>> entry){
        boolean found = false;
        for(Tier children : path.getChildren()){
            //search inside all the children of the current element
            if(children.hasChildren()){
                //if it has children go in each one of them
                found = wasEntryAddedToExistingChildren(children, entry);
            }

            //when the key we search for is equal to the current children we append it, signal
            // the parent that was found and break out of the search
            if (entry.getKey().equals(children.getName())) {
                children.setChildrenList(entry.getValue());
                found = true;
                break;
            }
        }

        return found;
    }

    public void transformToListOfObjects(Map<String, List<String>> incomingMap){
        //For every entry found in the DB we must add it to the tree of Tier objects
        for (Map.Entry<String, List<String>> entry : incomingMap.entrySet()){
            boolean found = false;
            Tier buffer = new Tier();

            //For all the possible paths discovered already we
            // inspect if it is possible to add the current entry to one of the children
            for (Tier path: menuItems){
                found = wasEntryAddedToExistingChildren(path,entry);
            }

            //It was not possible to add it, we create a new Tier object with this entry and add it to the list of menu items
            if(!found) {
                buffer.setName(entry.getKey());
                buffer.setChildrenList(entry.getValue());
                menuItems.add(buffer);
            }
        }

    }

	public String run_recursion(Tier receivedElement) {
		StringBuilder localHtmlHolder = new StringBuilder();

		if (receivedElement.getChildren().size() > 0) {
			localHtmlHolder.append("<li>");
			localHtmlHolder.append("<label label-default='' class='tree-toggle nav-header'>").append(receivedElement.getName()).append("</label>");

			localHtmlHolder.append("<ul class='nav tree'>");
			for (Tier localChildren : receivedElement.getChildren()) {
				localHtmlHolder.append(run_recursion(localChildren));
			}
			localHtmlHolder.append("</ul>");
			localHtmlHolder.append("</li>");
		}else{
			localHtmlHolder.append("<li><a href='#'>").append(receivedElement.getName()).append("</a></li>");
		}

		if (receivedElement.getChildren().size() > 0) {
			localHtmlHolder.append("<li class='divider'></li>");
		}

		return localHtmlHolder.toString();
	}

}
