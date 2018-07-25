package app.config.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.config.model.NodeChildren;

@Repository
public interface NodeChildrenRepository extends JpaRepository<NodeChildren,Integer> {
	
	//NodeChildren findBynodeName(String nodeName);
	
}