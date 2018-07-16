package app.config.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.config.model.ModuleUI;

@Repository
public interface ModuleUIRepository extends JpaRepository<ModuleUI, Integer>{

	List<ModuleUI> findByParentLabel(String parentLabel);
}
