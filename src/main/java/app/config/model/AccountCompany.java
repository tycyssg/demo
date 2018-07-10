package app.config.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ACC_COMPANY")
public class AccountCompany implements Serializable{
	
		
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		Integer id;
		String name;
		String address;
		
		@GeneratedValue(generator = "uuid")
	    @GenericGenerator(name = "uuid", strategy = "uuid")
	    @Column(columnDefinition = "CHAR(32)")
		@Id
		String uuid;

		@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "accCompany")
		public AccountUUID accUuid;
		
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

		public String getUuid() {
			return uuid;
		}

		public void setUuid(String uuid) {
			this.uuid = uuid;
		}
		
		
}
