package app.config.controller;



import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import app.config.model.ReceiveNode;
import app.config.model.NodeChildren;
import app.config.model.Node;
import app.config.repository.NodeRepository;
import app.config.service.AccountService;


@Controller
public class NodeController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private NodeRepository nodeRep;


	
	
	//Model to iterate trough maps
//	Iterator it = idsMap.entrySet().iterator();
//    while (it.hasNext()) {
//        Map.Entry pair = (Map.Entry)it.next();
//        System.out.println(pair.getKey() + " = " + pair.getValue());
//        it.remove(); // avoids a ConcurrentModificationException
//    }

	//testing purpose only
	@GetMapping("/test")
	public String test(HttpServletRequest request) {
		accountService.getUserStatusAndName(request);
		return "test";
	}
	
	//testing purpose only
	@PostMapping("/savenode")
	public String saveNode(HttpServletRequest request,@RequestBody ReceiveNode node) {
		accountService.getUserStatusAndName(request);
		Node n = new Node();
		NodeChildren nc = new NodeChildren();

		List<NodeChildren> nlist = new ArrayList<>();
		nlist.add(nc);
		
		n.setNodeName(node.getNodeName());
		n.setChildrens(nlist);
		nodeRep.save(n);
		
		return "redirect:"+"/test";
	}
	
	

}
