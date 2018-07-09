package app.config.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app.config.model.ParamSettingsDb;

@Repository
public interface ParamSettingsRepository extends CrudRepository<ParamSettingsDb, Integer>{

}
