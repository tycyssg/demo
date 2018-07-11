package app.config.service;



import java.lang.reflect.Array;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import app.config.model.Account;
import app.config.model.AccountCompanyDetails;
import app.config.model.AccountInvite;
import app.config.model.AccountPersonalAddress;
import app.config.model.AccountPersonalDetails;
import app.config.model.AccountUUID;
import app.config.model.Role;
import app.config.repository.AccCompanyRepository;
import app.config.repository.AccInviteRepository;
import app.config.repository.AccPersonalAddressRepository;
import app.config.repository.AccPersonalDetailsRepository;
import app.config.repository.AccUuidRepository;
import app.config.repository.AccountDAO;
import app.config.util.Constants.AccountStatus;


@Service
public class AccountService {
	
	@Value("${web.url}")
	private String baseUrl;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AccountDAO accDao;
	
	@Autowired
	private EmaiServiceImpl emailService;
	
	@Autowired
	private AccInviteRepository accInviteRep;
//	
//	@Autowired
//	private AccCompanyRepository accCompany;
//	
//	@Autowired
//	private AccUuidRepository accUuid;
//	

//	
//	@Autowired
//	private AccPersonalDetailsRepository accPersonalDetailsRep;
//	
//	@Autowired
//	private AccPersonalAddressRepository accPersonalAdd;


	public void saveSimpleAcc(String username,String email,String password) {
		Account acc = new Account();
		Role role = new Role();
		role.setRole("ADMIN");
		
		acc.setUsername(username);
		acc.setPassword(passwordEncoder.encode(password));
		acc.setStatus(AccountStatus.ONLINE);
		acc.setRoles(Arrays.asList(role));
		
		AccountUUID accountUuid = new AccountUUID();
		accountUuid.setAccount(acc);
		
		AccountPersonalDetails accPers = new AccountPersonalDetails();
		accPers.setEmail(email);
		accPers.setPersonalAccount(acc);
		
		
		AccountPersonalAddress accAdd = new AccountPersonalAddress();
		accAdd.setAccAddress(acc);
		
		
		AccountCompanyDetails accComp  = new AccountCompanyDetails();
		accComp.setAcc(acc);
			
		acc.setAccUuid(accountUuid);
		acc.setAccpers(accPers);
		acc.setAccPersAddres(accAdd);
		acc.setAccCompany(accComp);
		
		accountUuid.setRef_UUID(acc.getId());
		accDao.save(acc);
		
		
	}
	
	public void saveInvitedAcc(HttpServletRequest request,String username,String email,String password,String hashString) {
		
		AccountInvite accInv = accInviteRep.findByHashString(hashString);
		Long currentTime = new Timestamp(System.currentTimeMillis()).getTime();
		Long expired = currentTime - accInv.getTimestamp() / (1000 * 60 * 60 * 24);
		Account acc = accInv.getAccInvite();
		
		if(expired > 10) {
			request.setAttribute("linkExpired", true);
		}else {
			
			
			Role role = new Role();
			role.setRole("ADMIN");
			
			acc.setUsername(username);
			acc.setPassword(passwordEncoder.encode(password));
			acc.setStatus(AccountStatus.ONLINE);
			acc.setRoles(Arrays.asList(role));
			
			AccountUUID accountUuid = new AccountUUID();
			accountUuid.setAccount(acc);
			
			AccountPersonalDetails accPers = new AccountPersonalDetails();
			accPers.setEmail(email);
			accPers.setPersonalAccount(acc);
			
			
			AccountPersonalAddress accAdd = new AccountPersonalAddress();
			accAdd.setAccAddress(acc);
			
			
			AccountCompanyDetails accComp  = new AccountCompanyDetails();
			accComp.setAcc(acc);
				
			acc.setAccUuid(accountUuid);
			acc.setAccpers(accPers);
			acc.setAccPersAddres(accAdd);
			acc.setAccCompany(accComp);
			
			accountUuid.setRef_UUID(acc.getId());
			accDao.save(acc);
		}
		
		
		
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
	
	
	public void inviteSomeone(String email,String username) {
		Timestamp time = new Timestamp(System.currentTimeMillis());
		
		String hash =  UUID.randomUUID().toString().toUpperCase();
		String urlGenerated = baseUrl+"login?register=newacc&hash="+hash;
		
		Account acc = accDao.findByUsername(username);
		
		AccountInvite accInvite = new AccountInvite();
		
		accInvite.setHash(hash);
		accInvite.setAccInvite(acc);
		accInvite.setTimestamp(time.getTime());	
		
		acc.setAccInv(accInvite);
		
		String userEmail = acc.getAccpers().getEmail();
				
		emailService.sendInvitation(email,urlGenerated,userEmail);
		accDao.save(acc);
		
		System.out.println("Invitation Generated");
		System.out.println(urlGenerated);
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

