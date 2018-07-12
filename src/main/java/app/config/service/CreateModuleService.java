package app.config.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

import app.config.model.ModuleCreationDb;
import app.config.repository.CreateModuleRepository;

@Service
@Transactional
public class CreateModuleService {

	 private CreateModuleRepository createModuleRepository;


	public CreateModuleService(CreateModuleRepository createModuleRepository) {
		this.createModuleRepository = createModuleRepository;
	}
	
	public List<ModuleCreationDb> findAllModules(){
		List<ModuleCreationDb> modules = new ArrayList<>();
		for(ModuleCreationDb module : createModuleRepository.findAll()){
			modules.add(module);
		}
		return modules;
	}
	
	public ModuleCreationDb findModule(int id){
		return createModuleRepository.findOne(id);
	}
	
	public void save(ModuleCreationDb module){
		createModuleRepository.save(module);
	}
	

	public void delete(int id){
		createModuleRepository.delete(id);
	}
}
