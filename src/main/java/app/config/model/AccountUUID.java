package app.config.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ACCUUID")
public class AccountUUID implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(columnDefinition = "CHAR(32)")
	private String ref_UUID;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "company_id", nullable = false)
    private AccountCompany accCompany;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRefUUID() {
		return ref_UUID;
	}
	public void setRefUUID(String refUUID) {
		this.ref_UUID = refUUID;
	}

	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public String getRef_UUID() {
		return ref_UUID;
	}
	public void setRef_UUID(String ref_UUID) {
		this.ref_UUID = ref_UUID;
	}
	public AccountCompany getAccCompany() {
		return accCompany;
	}
	public void setAccCompany(AccountCompany accCompany) {
		this.accCompany = accCompany;
	}
	
	
	
}
