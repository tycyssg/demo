package app.config.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import app.config.model.Account;
import app.config.model.AccountCompany;
import app.config.model.AccountUUID;
import app.config.model.Role;
import app.config.repository.AccCompanyRepository;
import app.config.repository.AccUuidRepository;
import app.config.repository.AccountDAO;
import app.config.util.Constants.AccountStatus;


@Service
public class AccountService {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AccountDAO accDao;
	
	@Autowired
	private AccCompanyRepository accCompany;
	
	@Autowired
	private AccUuidRepository accUuid;

	
	public void saveSimpleAcc(String username,String email,String password) {
		Account acc = new Account();
		Role role = new Role();
		Role role1 = new Role();
		AccountCompany accComp  = new AccountCompany();
		AccountUUID accountUuid = new AccountUUID();
		accountUuid.setAccount(acc);
		
		List<Role> roles = new ArrayList<>();
		role.setRole("ADMIN");
		role1.setRole("CEO");
		
		roles.add(role1);
		roles.add(role);
		
		accComp.setAddress("test address");
		accComp.setName("test name");
		accComp.setAcc(acc);
		
		acc.setUsername(username);
		acc.setEmail(email);
		acc.setPassword(passwordEncoder.encode(password));
		acc.setStatus(AccountStatus.ONLINE);
		acc.setRoles(roles);
	
		accCompany.save(accComp);
		accDao.save(acc);
		accUuid.save(accountUuid);
		accountUuid.setRef_UUID(accDao.findByUsername(username).getId());
		accUuid.save(accountUuid);
		

	}
	
	
	
	
	
	
	public void getUserStatusAndName(HttpServletRequest request) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		 String currentUserName = "";
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		     currentUserName = authentication.getName();
		    
		}
		if(!(authentication instanceof AnonymousAuthenticationToken) && (authentication.isAuthenticated())) {
			request.setAttribute("login", true);
			request.setAttribute("userLogat", currentUserName);
		}
	}
	
	
//	//pass hash
//		public String refUUIDhash(String uuid) {
//			String hasResult = "";
//			try{
//			MessageDigest md = MessageDigest.getInstance("MD5");
//			md.update(uuid.getBytes());
//			byte[] digest = md.digest();
//			
//			hasResult = DatatypeConverter.printHexBinary(digest).toUpperCase();
//			
//			}catch(NoSuchAlgorithmException e){
//				e.printStackTrace();
//			}
//			return hasResult;
//		}
//		
		
	}

