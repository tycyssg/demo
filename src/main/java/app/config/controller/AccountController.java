package app.config.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import app.config.service.AccountService;

@Controller
public class AccountController {
	
	@Autowired
	AccountService accService;
	
	@PostMapping("/registeracc")
	public String register(HttpServletRequest request,@RequestParam String username,String email,String password) {
		
		accService.saveSimpleAcc(username, email, password);
		System.out.println("Acc created");
		return "login";
	}
}
