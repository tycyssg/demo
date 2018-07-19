package app.config.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import app.config.util.Constants;

@Entity
@Table(name = "ACC_DETAILS")
public class AccountPersonalDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	private String name = null;
	private String surName = null;
	@Column(unique = true, nullable = false)
	private String email;
	private String phone = null;
	private String accCreated = new Constants().currentDate();
	
	
	@OneToOne
	@JoinColumn(name = "account_id")
	private Account account;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSurName() {
		return surName;
	}


	public void setSurName(String surName) {
		this.surName = surName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}



	public Account getPersonalAccount() {
		return account;
	}


	public void setPersonalAccount(Account personalAccount) {
		this.account = personalAccount;
	}


	public String getAccCreated() {
		return accCreated;
	}


	public void setAccCreated(String accCreated) {
		this.accCreated = accCreated;
	}


	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
	}



	
	
}
