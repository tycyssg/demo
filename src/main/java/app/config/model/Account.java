package app.config.model;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIgnore;

import app.config.util.Constants.AccountStatus;

@Entity
@Table(name = "Accounts")
public class Account{

	
	@Id
	@Column(unique = true, name = "id", nullable = false)
	private String id = UUID.randomUUID().toString().toUpperCase();

	@Column(unique = true, nullable = false)
	private String username;

	@JsonIgnore
	@Column(nullable = false)
	private String password;

	@Column(unique = true, nullable = false)
	private String email;

	private String name;

	private String surName;
	
	@Enumerated
	private AccountStatus status;
	
	@Version
	@JsonIgnore
	private int version;

	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinColumn(name = "account_id")
	public List<Role> roles;
	
	@OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="acc")
	private AccountCompany accCompany;

	@OneToOne(fetch = FetchType.LAZY,cascade =  CascadeType.ALL, mappedBy = "account")
	public AccountUUID accUuid;
	
	public AccountUUID getAccUuid() {
		return accUuid;
	}

	public void setAccUuid(AccountUUID accUuid) {
		this.accUuid = accUuid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public AccountStatus getStatus() {
		return status;
	}

	public void setStatus(AccountStatus status) {
		this.status = status;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public AccountCompany getAccCompany() {
		return accCompany;
	}

	public void setAccCompany(AccountCompany accCompany) {
		this.accCompany = accCompany;
	}

	@JsonIgnore
	public String[] getAuthorities() {
		String[] authorities = new String[this.roles.size()];
		for (int i = 0; i < this.roles.size(); i++) {
			authorities[i] = "ROLE_" + this.roles.get(i).getRole();
		}
		return authorities;
	}

}