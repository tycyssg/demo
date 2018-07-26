package app.config.controller;

import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonAnyFormatVisitor;

import app.config.dto.AddUserAddress;
import app.config.dto.AddUserDetails;
import app.config.model.Account;
import app.config.model.AccountPersonalDetails;
import app.config.service.AccountService;

@Controller
public class AccountController {

	@Autowired
	AccountService accService;


//	@GetMapping("/login")
//	public String login() {
//		return "login";
//	}
	
	//H2 Login Only
	int count = 0;
	@GetMapping("/login")
	public String login() {
		if (count == 0) {
			accService.saveAcc("tycy", "tycy", "tycy");
			count++;
		}
		return "login";
	}

	
	@GetMapping("/register")
	public String register() {
		return "register";
	}

	boolean called = false;
	@PostMapping("/registeracc")
	public String register(RedirectAttributes attributes, String username, String email, String password,
			String hashString) {
		called = false;
		Pattern p = Pattern.compile("[^A-Za-z0-9]");
		boolean b = p.matcher(username).find();

		handleVariable("emptyUserOrMail", isStringEmpty(username) || isStringEmpty(email), attributes);
		handleVariable("specialChars", b,attributes);
		handleVariable("emailExist", accService.checkIfMailExist(email), attributes);
		handleVariable("emailValid", accService.checkIfMailIsValid(email), attributes);
		handleVariable("userExist", accService.checkIfUserExist(username), attributes);
		
		System.out.println("in the save method" + called+"=>"+b);
		
		if (!called) {
			if (hashString.equals("")) {
				accService.saveAcc(username, email, password);
				System.out.println("after save method");
			} else {
				accService.saveAcc(attributes, username, email, password, hashString);
			}
			System.out.println("near set attribute");
			attributes.addFlashAttribute("accCreated", true);
		}

		return "redirect:"+"/login";
	}

	private boolean isStringEmpty(String incString) {
		return (incString == null || incString.trim().isEmpty());
	}

	private void handleVariable(String name, boolean value, RedirectAttributes attributes) {
		if(value) {
			called = true;
		}
		attributes.addFlashAttribute(name, value);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/cp")
	public String userCP(HttpServletRequest request) {
		accService.getUserStatusAndName(request);
		//accService.getCurrentUserDetails(request,accService.getCurrentUser());
		request.setAttribute("classCp", "active");
		return "cp";
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/invitesomeone")
	public String inviteSomeone(RedirectAttributes attributes,@RequestParam String emailInvite, String username,HttpServletRequest request) {
		System.out.println(emailInvite + " " + username);
		if(!accService.checkIfMailIsValid(emailInvite)) {
			accService.inviteSomeone(emailInvite, username);
			attributes.addFlashAttribute("mailSent", true);
			attributes.addFlashAttribute("classInvite", "active");
		}else {
			attributes.addFlashAttribute("mailInvalid", true);
			attributes.addFlashAttribute("classInvite", "active");
		}

		return "redirect:"+"/cp?tab=invite";
	}

	@PostMapping("/adduserdetails")
	@ResponseBody
	public String addUserDetails(@RequestBody AddUserDetails userD) {
		 accService.addUserDetails(userD.getUsername(), userD.getName(), userD.getSurname(), userD.getPhone());
		//System.out.println(acc.toString());
//		String x = "{\"value\":\"d\"}";
		String x = "10";
		return x;
	}
	
	@PostMapping("/adduseraddress")
	public String addUserAddress(@RequestBody AddUserAddress userAddress,HttpServletRequest request) {
		accService.addUserAddress(userAddress, request);
		return "cp";
	}
	
	
	
}
