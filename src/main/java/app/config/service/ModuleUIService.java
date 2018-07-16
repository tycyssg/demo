package app.config.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.config.model.ModuleUI;
import app.config.repository.ModuleUIRepository;

@Service
public class ModuleUIService {

	@Autowired
	private ModuleUIRepository moduleUiRep;
	
	
	public void addModuleUiLabel(String creator,String friendlyName,String parentName) {
		ModuleUI moduleUi = new ModuleUI();
		moduleUi.setCreator(creator);
		moduleUi.setFriendlyName(friendlyName);
		moduleUi.setParentLabel(parentName);
		moduleUi.setObjectType(null);
		moduleUiRep.save(moduleUi);
	}
	
	
	public void createModuleLabelUi(HttpServletRequest request) {
		List<ModuleUI> allUis =   moduleUiRep.findAll();
		List<String> childName = new ArrayList<>();
		List<String> tmpUi = new ArrayList<>();
		
		Map<String,List<String>> moduleUiMap = new LinkedHashMap<String, List<String>>();

		for(int i = 0;i < allUis.size() ;i++) {
			
			if(tmpUi.contains(allUis.get(i).getParentLabel())) {
				continue;
			}else {
				List<ModuleUI> childList =  moduleUiRep.findByParentLabel(allUis.get(i).getParentLabel());
				childName = new ArrayList<>();
				for(ModuleUI mUi : childList) {
					
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
