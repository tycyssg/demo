package app.config.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import app.config.model.AccountInvite;

public interface AccInviteRepository extends JpaRepository<AccountInvite,Integer> {
	
	@Query("select acc from Account acc where hash= :hashString")
	public AccountInvite findByHashString(@Param("hashString") String hashString);

}