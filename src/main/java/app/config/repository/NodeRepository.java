package app.config.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.config.model.Node;

@Repository
public interface NodeRepository extends JpaRepository<Node,Integer> {
	

}