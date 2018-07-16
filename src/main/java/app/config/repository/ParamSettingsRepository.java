package app.config.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.config.model.ParamSettingsDb;

@Repository
public interface ParamSettingsRepository extends JpaRepository<ParamSettingsDb, Integer>{

}
