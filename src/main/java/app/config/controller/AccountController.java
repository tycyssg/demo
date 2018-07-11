package app.config.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import app.config.service.AccountService;

@Controller
public class AccountController {
	
	@Autowired
	AccountService accService;
	
	@PostMapping("/registeracc")
	public String register(HttpServletRequest request,String username,String email,String password,String hashString) {
		
			if(hashString.equals("")) {
			accService.saveSimpleAcc(username, email, password);
			System.out.println("Acc created");	
		}else {
			accService.saveInvitedAcc(request,username, email, password, hashString);
		}
		
		return "login";
	}
	
	@GetMapping("/cp")
	public String userCP(HttpServletRequest request) {
		accService.getUserStatusAndName(request);
		return "cp";
	}
	
	
	@PostMapping("/invitesomeone")
	public String inviteSomeone(@RequestParam String email,String username) {
		System.out.println(email + " "+ username);
		accService.inviteSomeone(email, username);
		return "cp";
	}
	
}
