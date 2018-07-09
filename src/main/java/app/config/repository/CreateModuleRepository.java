package app.config.repository;

import org.springframework.data.repository.CrudRepository;

import app.config.model.ModuleCreationDb;

public interface CreateModuleRepository extends CrudRepository<ModuleCreationDb, Integer>{

}
