package app.config.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ACC_DETAIL_ADDRESS")
public class AccountPersonalAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	private String street_space_1 = null;
	private String street_space_2 = null;
	private String houseNo = null;
	private String city = null;
	private String country = null;
	private String postCode = null;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "account_id")
	private Account account;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStreet_space_1() {
		return street_space_1;
	}

	public void setStreet_space_1(String street_space_1) {
		this.street_space_1 = street_space_1;
	}

	public String getStreet_space_2() {
		return street_space_2;
	}

	public void setStreet_space_2(String street_space_2) {
		this.street_space_2 = street_space_2;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public Account getAccAddress() {
		return account;
	}

	public void setAccAddress(Account accAddress) {
		this.account = accAddress;
	}


	
	
	
	
}
