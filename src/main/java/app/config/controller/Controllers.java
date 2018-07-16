package app.config.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import app.config.dto.EditFileConfig;
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
public class Controllers {

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
	
	

	@GetMapping("/")
	public String home(HttpServletRequest request) {
		accountService.getUserStatusAndName(request);
		request.setAttribute("mode", "HOME");
		return "index";
	}

	@GetMapping("/modules")
	public String modules(HttpServletRequest request) {
		accountService.getUserStatusAndName(request);
		moduleUiService.createModuleLabelUi(request);
		return "modules";
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
	
	

	@GetMapping("/testform")
	public String test() {
		return "testform";
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

	@GetMapping("/accessd")
	public String accessd(HttpServletRequest request) {
		return "accessd";
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/cfg-index")
	public String wsIndex(HttpServletRequest request) throws ClassNotFoundException, IOException {
		accountService.getUserStatusAndName(request);
		if(taskService.getFilesName().size() > 0) {
			request.setAttribute("filesNames", taskService.getFilesName());
		}
		request.setAttribute("mode", "WS_INDEX");
		return "cfg-index";
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/test-display")
	public String testIndex(HttpServletRequest request) throws ClassNotFoundException, IOException {
		accountService.getUserStatusAndName(request);
		request.setAttribute("mode", "TEST_INDEX");
		return "test-display";
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/send-update")
	public String updateTask(@Valid @RequestBody EditFileConfig editfile) throws IOException {
		taskService.writeInfo(editfile.getBefore(),editfile.getAfter(),editfile.getFileName(),editfile.getTime());
		return "cfg-index";
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/start-ws")
	public String startWs(@RequestParam String name, String file, HttpServletRequest request)
			throws IOException, ClassNotFoundException {
		accountService.getUserStatusAndName(request);
		request.setAttribute("name", name);
		request.setAttribute("file", file);

		request.setAttribute("info", taskService.findInfo(file));
		request.setAttribute("mode", "MODE_FILES");
		return "cfg-index";
	}
}
