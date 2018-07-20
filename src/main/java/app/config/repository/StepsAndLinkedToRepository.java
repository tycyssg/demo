package app.config.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.config.model.StepsAndLinkedTo;


@Repository
public interface StepsAndLinkedToRepository extends JpaRepository<StepsAndLinkedTo,Integer> {

}