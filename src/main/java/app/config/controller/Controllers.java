package app.config.controller;

import java.io.IOException;

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
import app.config.service.AccountService;
import app.config.service.TaskService;


@Controller
public class Controllers {

	@Autowired
	private TaskService taskService;
	
	@Autowired
	private AccountService accountService;




	@GetMapping("/")
	public String home(HttpServletRequest request) {
		accountService.getUserStatusAndName(request);
		request.setAttribute("mode", "HOME");
		return "index";
	}


	@GetMapping("/testform")
	public String test() {
		return "testform";
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
