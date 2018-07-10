package app.config.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import app.config.model.AccountUUID;

public interface AccUuidRepository extends JpaRepository<AccountUUID,Integer> {
	

}