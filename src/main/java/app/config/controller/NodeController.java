package app.config.controller;



import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import app.config.model.NodeChildren;
import app.config.dto.ReceiveNode;
import app.config.model.NewNode;
import app.config.model.Node;
import app.config.repository.NodeChildrenRepository;
import app.config.repository.NodeRepository;
import app.config.repository.NodeRepository2;
import app.config.service.AccountService;


@Controller
public class NodeController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private NodeRepository nodeRep;
	
	@Autowired
	private NodeRepository2 nodeRep2;
	
	
	@Autowired
	private NodeChildrenRepository nodeCRep;


	
	
	//Model to iterate trough maps
//	Iterator it = idsMap.entrySet().iterator();
//    while (it.hasNext()) {
//        Map.Entry pair = (Map.Entry)it.next();
//        System.out.println(pair.getKey() + " = " + pair.getValue());
//        it.remove(); // avoids a ConcurrentModificationException
//    }

	//testing purpose only
//	@GetMapping("/test")
//	public String test(HttpServletRequest request) {
//		accountService.getUserStatusAndName(request);
//		
//		return "test";
//	}
	
	@GetMapping("/test")
	public ModelAndView test(HttpServletRequest request) {
		ObjectMapper mapper = new ObjectMapper();
		
		if(nodeRep.findAll().isEmpty()) {
			//create First Node Object
			Node node = new Node();
			NodeChildren nc = new NodeChildren();
			List<NodeChildren> nlist = new ArrayList<>();
			nlist.add(nc);
			node.setChildrens(nlist);
			nodeRep.save(node);
		}
		
		List<Node> nodeList = nodeRep.findAll();
		ModelAndView model = new ModelAndView("test");
		
		String json = "";
		try {
			json = mapper.writeValueAsString(nodeList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addObject("nodeList", json);
		
		return model;
		
	
	}
	
	//testing purpose only
	@PostMapping("/savenode")
	public String saveNode(HttpServletRequest request,@RequestBody ReceiveNode node) {
		accountService.getUserStatusAndName(request);
		
		System.out.println(node.toString());
		
	//	Node n = nodeRep.findOne(Integer.valueOf(node.getNodeId()));
		Node n = new Node();
		List<NodeChildren> nlistUpd = n.getChildrens();
		
		n.setId(Integer.valueOf(node.getNodeId()));
		n.setNodeName(node.getNodeName());
		
		if(!node.getNodeFather().equals(node.getNodeId())) {
			Node nf = nodeRep.findOne(Integer.valueOf(node.getNodeFather()));
			NodeChildren ncUp = new NodeChildren();
			ncUp.setChildrenId(nf.getId());
			nlistUpd.add(ncUp);
			n.setChildrens(nlistUpd);
		}
		
		nodeRep.save(n);

		return "redirect:"+"/test";
	}
	
	

	//testing purpose only
		@PostMapping("/createNewNode")
		@ResponseBody
		public String createNewNode() {
			Node node = new Node();
			NodeChildren nc = new NodeChildren();
			List<NodeChildren> nlist = new ArrayList<>();
			nlist.add(nc);
			node.setChildrens(nlist);
			nodeRep.save(node);
			
			String id = node.getId().toString();
			
			System.out.println("node id "+ id);
		
			return id;
		}
}
