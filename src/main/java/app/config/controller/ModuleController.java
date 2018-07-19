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
import app.config.service.ModuleService;
import app.config.service.LabelUIService;
import app.config.service.ObjectsMapper;
import app.config.service.TaskService;


@Controller
public class ModuleController {

	@Autowired
	private TaskService taskService;
	
	@Autowired
	private AccountService accountService;

	@Autowired
	private ModuleService moduleService;

	@Autowired
	private ObjectsMapper objMapper;
	
	@Autowired
	private LabelUIService labelUiService;
	
	


	@GetMapping("/labelsui")
	public String modules(HttpServletRequest request) {
		accountService.getUserStatusAndName(request);
		labelUiService.createModuleLabelUi(request);
		return "labelsui";
	}
	
	@GetMapping("/modulesDisplay")
	public String modulesDisplay(@RequestParam int id,HttpServletRequest request) {
		accountService.getUserStatusAndName(request);
		
		ModuleCreationDb module = moduleService.findModule(id);
		List<ParamSettingsDb> params = module.getParams();
		Map<String,String> paramsMap = new HashMap<String, String>();
		
		for(ParamSettingsDb param : params) {
			paramsMap.put(param.getParamname(), param.getParamtype());
		}
		request.setAttribute("paramsMap", paramsMap);
		request.setAttribute("paramId", id);
		
		return "modulesdisplay";
	}
	


	@PostMapping("/moduledisplayreceiver")
	public String moduleDisplayReceiver(@RequestBody Map<String,Object> paramsMap) {	
		moduleService.turnMapIntoList(paramsMap);
		return "modulesdisplay";
	}
	
	
	@GetMapping("/modulesUiCreate")
	public String modulesUiCreate(HttpServletRequest request) {
		accountService.getUserStatusAndName(request);
		return "modulesuicreate";
	}
	
	
	@PostMapping("/modulesUireceive")
	public String moduleUiReceiver(String creator,String friendlyName,String parentName) {
		labelUiService.addModuleUiLabel(creator, friendlyName, parentName);
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
