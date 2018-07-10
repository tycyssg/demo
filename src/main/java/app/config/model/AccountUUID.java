package app.config.model;

import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "ACCUUID")
public class AccountUUID {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(unique = true, name = "uuid_ref", nullable = false)
	private String ref_UUID = UUID.randomUUID().toString().toUpperCase();

	@Column(unique = true, name = "uuid_company", nullable = false)
	private String company_UUID = UUID.randomUUID().toString().toUpperCase();

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "acc_id")
	private Account account;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRef_UUID() {
		return ref_UUID;
	}

	public void setRef_UUID(String ref_UUID) {
		this.ref_UUID = ref_UUID;
	}

	public String getCompany_UUID() {
		return company_UUID;
	}

	public void setCompany_UUID(String company_UUID) {
		this.company_UUID = company_UUID;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
