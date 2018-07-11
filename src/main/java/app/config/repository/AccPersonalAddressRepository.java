package app.config.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import app.config.model.AccountCompanyDetails;
import app.config.model.AccountPersonalAddress;
import app.config.model.AccountPersonalDetails;

public interface AccPersonalAddressRepository extends JpaRepository<AccountPersonalAddress,Integer> {
	

}