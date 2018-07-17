package app.config.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import app.config.dto.ModuleCreation;
import app.config.dto.ParamSettings;
import app.config.model.ModuleCreationDb;
import app.config.model.ParamSettingsDb;
import app.config.service.AccountService;
import app.config.service.CreateModuleService;
import app.config.service.ModuleUIService;
import app.config.service.ObjectsMapper;
import app.config.service.TaskService;


@Controller
public class ModuleController {

	@Autowired
	private TaskService taskService;
	
	@Autowired
	private AccountService accountService;

	@Autowired
	private CreateModuleService moduleService;

	@Autowired
	private ObjectsMapper objMapper;
	
	@Autowired
	private ModuleUIService moduleUiService;
	
	


	@GetMapping("/modules")
	public String modules(HttpServletRequest request) {
		accountService.getUserStatusAndName(request);
		moduleUiService.createModuleLabelUi(request);
		return "modules";
	}
	
	@GetMapping("/modulesDisplay")
	public String modulesDisplay(@RequestParam int id,HttpServletRequest request) {
		accountService.getUserStatusAndName(request);
		
		ModuleCreationDb module = moduleService.findModule(id);
		List<ParamSettingsDb> params = module.getParams();
		Map<String,String> paramsMap = new HashMap<String, String>();
		
		for(ParamSettingsDb param : params) {
			paramsMap.put(param.getParamname(), param.getParamtype());
			System.out.println(param.getParamname() +" == "+ param.getParamtype());
		}
		request.setAttribute("paramsMap", paramsMap);
		
		return "modulesdisplay";
	}
	


	@PostMapping("/moduledisplayreceiver")
	public String moduleDisplayReceiver(@RequestBody Map<String,Object> paramsMap) {
		
		System.out.println("a primit pos-ul");
		
		 Iterator it = paramsMap.entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
		        System.out.println(pair.getKey() + " = " + pair.getValue());
		        it.remove(); // avoids a ConcurrentModificationException
		    }
		
		return "modulesdisplay";
	}
	
	
	@GetMapping("/modulesUiCreate")
	public String modulesUiCreate(HttpServletRequest request) {
		accountService.getUserStatusAndName(request);
		return "modulesuicreate";
	}
	
	
	@PostMapping("/modulesUireceive")
	public String moduleUiReceiver(String creator,String friendlyName,String parentName) {
		moduleUiService.addModuleUiLabel(creator, friendlyName, parentName);
		System.out.println("Success " + creator +" - "+ friendlyName +" - "+ parentName);
		return "redirect:" + "/modulesUiCreate";
	}
	
	
	@GetMapping("/createModule")
	public String createModule(HttpServletRequest request) {
		accountService.getUserStatusAndName(request);
		return "createmodule";
	}

	@PostMapping("/createmodulereceiver")
	public String moduleReceiver(@Valid @RequestBody ModuleCreation moduleCreation) throws IOException {
		String fileName = taskService.createFileWithExtension(moduleCreation.getCatname(),
				moduleCreation.getFileextension());
		taskService.createModuleInFile(fileName, moduleCreation.getCatcode());
		List<ParamSettingsDb> list = new ArrayList<>();

		for (ParamSettings param : moduleCreation.getParams()) {
			list.add(objMapper.mapParamSettings(param));
		}

		ModuleCreationDb moduleC = new ModuleCreationDb(moduleCreation.getLabel(), moduleCreation.getCatname(),
				moduleCreation.getCatdes(), moduleCreation.getCatlink(), list);

		moduleService.save(moduleC);

		return "createmodule";
	}


}
