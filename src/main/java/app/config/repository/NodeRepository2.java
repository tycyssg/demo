package app.config.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.config.model.NewNode;
import app.config.model.Node;

@Repository
public interface NodeRepository2 extends JpaRepository<NewNode,Integer> {
	
	//Node findBynodeName(String nodeName);
	
}