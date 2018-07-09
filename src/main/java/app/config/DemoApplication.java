package app.config;

import org.h2.tools.Server;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import app.config.model.AddingModule;
import app.config.repository.AddingModuleRepository;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
//	
//	@Bean
//	CommandLineRunner runner(AddingModuleRepository repo) {
//		return args ->{
//			repo.save(new AddingModule("Pagination", "PagEx1", "Describe pagination", "paginationex.html", "youtube.com", 5,"Name1,Name2,Name3,Name4,Name5"));
//		};
//	}
	
	@Bean
	public Server h2Server() {
	    Server server = new Server();
	    try {
	        server.runTool("-tcp");
	        server.runTool("-tcpAllowOthers");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return server;

	}
}
