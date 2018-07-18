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

@Service
public class LabelUIService {

	@Autowired
	private LabelUIRepository labelUiRep;
	
	
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
		List<String> tmpUi = new ArrayList<>();
		
		Map<String,List<String>> moduleUiMap = new LinkedHashMap<String, List<String>>();

		for(int i = 0;i < allUis.size();i++) {
			
			if(tmpUi.contains(allUis.get(i).getParentLabel())) {
				continue;
			}else {
				List<LabelUI> childList =  labelUiRep.findByParentLabel(allUis.get(i).getParentLabel());
				childName = new ArrayList<>();
				for(LabelUI mUi : childList) {
					
					childName.add(mUi.getFriendlyName());
				}
				moduleUiMap.put(allUis.get(i).getParentLabel(), childName);
				tmpUi.add(allUis.get(i).getParentLabel());
				
			}
				
		System.out.println(moduleUiMap.toString());		
		}
		request.setAttribute("labelsDisplay",moduleUiMap);
	

		
	}
	
}
