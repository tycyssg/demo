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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import app.config.model.AddUserAddress;
import app.config.model.AddUserDetails;
import app.config.service.AccountService;

@Controller
public class AccountController {

	@Autowired
	AccountService accService;

	int count = 0;

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/register")
	public String register() {
		return "register";
	}

	boolean called = false;
	@PostMapping("/registeracc")
	public String register(HttpServletRequest request, String username, String email, String password,
			String hashString) {
		called = false;
		Pattern p = Pattern.compile("[^A-Za-z0-9]");
		boolean b = p.matcher(username).find();

		handleVariable("emptyUserOrMail", isStringEmpty(username) || isStringEmpty(email), request);
		handleVariable("specialChars", b,request);
		handleVariable("emailExist", accService.checkIfMailExist(email), request);
		handleVariable("emailValid", accService.checkIfMailIsValid(email), request);
		handleVariable("userExist", accService.checkIfUserExist(username), request);
		
		System.out.println("in the save method" + called+"=>"+b);
		
		if (!called) {
			if (hashString.equals("")) {
				accService.saveAcc(username, email, password);
				System.out.println("after save method");
			} else {
				accService.saveAcc(request, username, email, password, hashString);
			}

			request.setAttribute("accCreated", true);
		}

		return "login";
	}

	private boolean isStringEmpty(String incString) {
		return (incString == null || incString.trim().isEmpty());
	}

	private void handleVariable(String name, boolean value, HttpServletRequest request) {
		request.setAttribute(name, value);
		called = true;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/cp")
	public String userCP(HttpServletRequest request) {
		accService.getUserStatusAndName(request);
		accService.getCurrentUserDetails(request,accService.getCurrentUser());
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
	public String addUserDetails(@RequestBody AddUserDetails userD,HttpServletRequest request) {
		accService.addUserDetails(userD.getUsername(), userD.getName(), userD.getSurname(), userD.getPhone(),request);
		return "cp";
	}
	
	@PostMapping("/adduseraddress")
	public String addUserAddress(@RequestBody AddUserAddress userAddress,HttpServletRequest request) {
		accService.addUserAddress(userAddress, request);
		return "cp";
	}
	
	
	
}
