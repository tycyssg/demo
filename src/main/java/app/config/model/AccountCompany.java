package app.config.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ACC_COMPANY")
public class AccountCompany{
	
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		Integer id;
		String name;
		String address;
		
		@OneToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "account_id")
		private Account acc;
		 

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

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public Account getAcc() {
			return acc;
		}

		public void setAcc(Account acc) {
			this.acc = acc;
		}

		
		
}
