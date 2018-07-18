package app.config.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.config.model.ModuleUserParams;

@Repository
public interface ModuleUserParamsRepository extends JpaRepository<ModuleUserParams,Integer> {

}

