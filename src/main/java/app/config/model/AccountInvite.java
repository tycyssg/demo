package app.config.model;



import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ACC_INVITE")
public class AccountInvite {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Long timestamp;
	private String hash;
	
	@OneToOne
	@JoinColumn(name = "account_id")
	private Account account;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public Account getAccInvite() {
		return account;
	}

	public void setAccInvite(Account accInvite) {
		this.account = accInvite;
	}

	@Override
	public String toString() {
		return "AccountInvite [id=" + id + ", timestamp=" + timestamp + ", hash=" + hash + ", account=" + account + "]";
	}
	
	
}
