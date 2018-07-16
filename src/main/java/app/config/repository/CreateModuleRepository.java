package app.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.config.model.ModuleCreationDb;

public interface CreateModuleRepository extends JpaRepository<ModuleCreationDb, Integer>{

}
