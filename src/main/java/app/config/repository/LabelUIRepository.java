package app.config.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.config.model.LabelUI;

@Repository
public interface LabelUIRepository extends JpaRepository<LabelUI, Integer>{

	List<LabelUI> findByParentLabel(String parentLabel);
}
