package app.config.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import app.config.service.AccountService;

@Controller
public class AccountController {

	@Autowired
	AccountService accService;

	int count = 0;

	@GetMapping("/login")
	public String login() {

		if (count == 0) {
			accService.saveSimpleAcc("tycy", "tycy", "tycy");
			count++;
		}

		return "login";
	}

	@GetMapping("/register")
	public String register() {
		return "register";
	}

	@PostMapping("/registeracc")
	public String register(HttpServletRequest request, String username, String email, String password,
			String hashString) {
		Pattern p = Pattern.compile("[^A-Za-z0-9]");
		Matcher m = p.matcher(username);
		Matcher m1 = p.matcher(email);
		boolean b = m.find();
		boolean e = m1.find();

		if (username == null || email == null || username.trim().isEmpty() || email.trim().isEmpty()) {
			request.setAttribute("emptyUserOrMail", true);
		} else if (b || e) {
			request.setAttribute("specialChars", true);
		} else {
			if (accService.checkIfMailExist(email)) {
				request.setAttribute("emailExist", true);
			} else if (!accService.checkIfMailExist(email)) {
				request.setAttribute("emailValid", true);
			} else if (accService.checkIfUserExist(username)) {
				request.setAttribute("userExist", true);
			} else {

				if (hashString.equals("")) {
					accService.saveSimpleAcc(username, email, password);
				} else {
					accService.saveInvitedAcc(request, username, email, password, hashString);
				}
				request.setAttribute("accCreated", true);
			}
		}

		return "login";
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/cp")
	public String userCP(HttpServletRequest request) {
		accService.getUserStatusAndName(request);
		return "cp";
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/invitesomeone")
	public String inviteSomeone(@RequestParam String email, String username) {
		System.out.println(email + " " + username);
		accService.inviteSomeone(email, username);
		return "cp";
	}

}
