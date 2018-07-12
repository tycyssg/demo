package app.config.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.config.model.AccountPersonalAddress;


@Repository
public interface AccPersonalAddressRepository extends JpaRepository<AccountPersonalAddress,Integer> {
	

}