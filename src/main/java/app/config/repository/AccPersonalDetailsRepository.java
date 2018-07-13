package app.config.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.config.model.AccountInvite;
import app.config.model.AccountPersonalDetails;

@Repository
public interface AccPersonalDetailsRepository extends JpaRepository<AccountPersonalDetails,Integer> {
	AccountPersonalDetails findByEmail(String email);

}