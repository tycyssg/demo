package app.config.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.config.model.AccountInvite;

@Repository
public interface AccInviteRepository extends JpaRepository<AccountInvite,Integer> {
	AccountInvite findByHash(String hash);
}

