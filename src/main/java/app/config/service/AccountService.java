package app.config.service;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.UUID;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
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
import app.config.model.AddUserAddress;
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

	@Autowired
	private AccCompanyRepository accCompany;

	@Autowired
	private AccUuidRepository accUuid;

	@Autowired
	private AccPersonalDetailsRepository accPersonalDetailsRep;

	@Autowired
	private AccPersonalAddressRepository accPersonalAdd;

	public void saveAcc(String username, String email, String password) {
		Account acc = new Account();
		Role role = new Role();
		role.setRole("ADMIN");

		acc.setUsername(username);
		acc.setPassword(passwordEncoder.encode(password));
		acc.setStatus(AccountStatus.ONLINE);
		acc.setRoles(Arrays.asList(role));
		accDao.save(acc);

		AccountUUID accountUuid = new AccountUUID();
		accountUuid.setRef_UUID(acc.getId());
		accountUuid.setAccount(acc);
		accUuid.save(accountUuid);

		AccountPersonalDetails accPers = new AccountPersonalDetails();
		accPers.setEmail(email);
		accPers.setPersonalAccount(acc);
		accPersonalDetailsRep.save(accPers);

		AccountPersonalAddress accAdd = new AccountPersonalAddress();
		accAdd.setAccAddress(acc);
		accPersonalAdd.save(accAdd);

		AccountCompanyDetails accComp = new AccountCompanyDetails();
		accComp.setAcc(acc);
		accCompany.save(accComp);

		acc.setAccUuid(accountUuid);
		acc.setAccpers(accPers);
		acc.setAccPersAddres(accAdd);
		acc.setAccCompany(accComp);

	}

	public void saveAcc(HttpServletRequest request, String username, String email, String password, String hashString) {

		AccountInvite accInv = accInviteRep.findByHash(hashString);
		Account acc = accInv.getAccInvite();
		Account newInvitedAcc = new Account();

		// Expire Link
		Long currentTime = new Timestamp(System.currentTimeMillis()).getTime();
		Long expired = (currentTime - accInv.getTimestamp()) / (1000 * 60 * 60 * 24);

		if (expired > 10) {
			request.setAttribute("linkExpired", true);
			accInviteRep.delete(accInv.getId());
			return;
		}

		Role role = new Role();
		role.setRole("ADMIN");

		newInvitedAcc.setUsername(username);
		newInvitedAcc.setPassword(passwordEncoder.encode(password));
		newInvitedAcc.setStatus(AccountStatus.ONLINE);
		newInvitedAcc.setRoles(Arrays.asList(role));
		accDao.save(newInvitedAcc);

		AccountUUID accountUuid = new AccountUUID();
		accountUuid.setCompany_UUID(acc.getAccUuid().getCompany_UUID());
		accountUuid.setRef_UUID(acc.getId());
		accountUuid.setAccount(newInvitedAcc);
		accUuid.save(accountUuid);

		AccountPersonalDetails accPers = new AccountPersonalDetails();
		accPers.setEmail(email);
		accPers.setPersonalAccount(newInvitedAcc);
		accPersonalDetailsRep.save(accPers);

		AccountPersonalAddress accAdd = new AccountPersonalAddress();
		accAdd.setAccAddress(newInvitedAcc);
		accPersonalAdd.save(accAdd);

		AccountCompanyDetails accComp = new AccountCompanyDetails();
		accComp.setAddress(acc.getAccCompany().getAddress());
		accComp.setName(acc.getAccCompany().getName());
		accComp.setAcc(newInvitedAcc);
		accCompany.save(accComp);

		newInvitedAcc.setAccUuid(accountUuid);
		newInvitedAcc.setAccpers(accPers);
		newInvitedAcc.setAccPersAddres(accAdd);
		newInvitedAcc.setAccCompany(accComp);

	}

	public void getUserStatusAndName(HttpServletRequest request) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentUserName = "";
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			currentUserName = authentication.getName();

		}
		if (!(authentication instanceof AnonymousAuthenticationToken) && (authentication.isAuthenticated())) {
			request.setAttribute("login", true);
			request.setAttribute("userLogat", currentUserName);
		}
	}
	
	public String getCurrentUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentUserName = "";
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			currentUserName = authentication.getName();

		}
		return currentUserName;
	}

	public void inviteSomeone(String email, String username) {
		Timestamp time = new Timestamp(System.currentTimeMillis());

		String hash = UUID.randomUUID().toString().toUpperCase();
		String urlGenerated = baseUrl + "login?register=newacc&hash=" + hash;

		Account acc = accDao.findByUsername(username);

		AccountInvite accInvite = new AccountInvite();

		accInvite.setHash(hash);
		accInvite.setAccInvite(acc);
		accInvite.setTimestamp(time.getTime());

		acc.setAccInv(accInvite);

		String userEmail = acc.getAccpers().getEmail();

		emailService.sendInvitation(email, urlGenerated, userEmail);
		accInviteRep.save(accInvite);

		System.out.println(urlGenerated);
	}

	public boolean checkIfMailExist(String email) {
		boolean exist = false;
		if (accPersonalDetailsRep.findByEmail(email) != null) {
			exist = true;
		}
		return exist;
	}

	public boolean checkIfUserExist(String user) {
		boolean exist = false;
		if (accDao.findByUsername(user) != null) {
			exist = true;
		}
		return exist;
	}

	public boolean checkIfMailIsValid(String email) {
		boolean exist = false;
		if (!isValidEmailAddress(email)) {
			exist = true;
		}
		return exist;
	}

	// email validation method
	public static boolean isValidEmailAddress(String email) {
		boolean result = true;
		try {
			InternetAddress emailAddr = new InternetAddress(email);
			emailAddr.validate();
		} catch (AddressException ex) {
			result = false;
		}
		return result;
	}
	
	public void addUserDetails(String username,String name,String surname,String phone,HttpServletRequest request) {
		Account acc = accDao.findByUsername(username);
		AccountPersonalDetails accP = acc.getAccpers();
		accP.setName(name);
		accP.setSurName(surname);
		accP.setPhone(phone);
		acc.setAccpers(accP);
		accDao.save(acc);		
	}
	
	public void addUserAddress(AddUserAddress userAddress,HttpServletRequest request) {
		Account acc = accDao.findByUsername(userAddress.getUsername());
		AccountPersonalAddress accAddress = acc.getAccPersAddres();
		
		accAddress.setStreet_space_1(userAddress.getLine1());
		accAddress.setStreet_space_2(userAddress.getLine2());
		accAddress.setHouseNo(userAddress.getHouseNo());
		accAddress.setCity(userAddress.getCity());
		accAddress.setCounty(userAddress.getCounty());
		accAddress.setPostCode(userAddress.getPostcode());
		accAddress.setCountry(userAddress.getCountry());
		acc.setAccPersAddres(accAddress);
		accDao.save(acc);

	}
	
	
	public void getCurrentUserDetails(HttpServletRequest request,String username) {
		Account acc = accDao.findByUsername(username);
		AccountPersonalDetails accP = acc.getAccpers();
		AccountPersonalAddress accAddress = acc.getAccPersAddres();
		
		request.setAttribute("name", accP.getName());
		request.setAttribute("surname",accP.getSurName());
		request.setAttribute("phone", accP.getPhone());
		
		request.setAttribute("line1", accAddress.getStreet_space_1());
		request.setAttribute("line2", accAddress.getStreet_space_2());
		request.setAttribute("house", accAddress.getHouseNo());
		request.setAttribute("city", accAddress.getCity());
		request.setAttribute("county", accAddress.getCounty());
		request.setAttribute("postcode", accAddress.getPostCode());
		request.setAttribute("country", accAddress.getCountry());
	}
	
}


