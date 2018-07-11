package app.config.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import app.config.model.AccountCompanyDetails;
import app.config.model.AccountPersonalDetails;

public interface AccPersonalDetailsRepository extends JpaRepository<AccountPersonalDetails,Integer> {
	

}