package app.config.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.config.model.AccountUUID;

@Repository
public interface AccUuidRepository extends JpaRepository<AccountUUID,Integer> {
	

}