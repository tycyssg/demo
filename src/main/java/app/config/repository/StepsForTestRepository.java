package app.config.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.config.model.StepsForTest;


@Repository
public interface StepsForTestRepository extends JpaRepository<StepsForTest,Integer> {
	

}