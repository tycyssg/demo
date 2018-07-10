package app.config.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import app.config.model.Account;
import app.config.model.AccountCompany;

public interface AccCompanyRepository extends JpaRepository<AccountCompany,Integer> {
	

}