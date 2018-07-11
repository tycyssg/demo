package app.config.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import app.config.model.AccountCompanyDetails;

public interface AccCompanyRepository extends JpaRepository<AccountCompanyDetails,Integer> {
	

}