package app.config.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.config.model.AccountCompanyDetails;

@Repository
public interface AccCompanyRepository extends JpaRepository<AccountCompanyDetails,Integer> {
	

}