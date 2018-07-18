package app.config.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.config.model.Account;
import app.config.model.ModuleCreationDb;
import app.config.model.ModuleUserParams;
import app.config.model.StepsForTest;
import app.config.repository.AccountDAO;
import app.config.repository.CreateModuleRepository;
import app.config.repository.ModuleUserParamsRepository;
import app.config.repository.StepsForTestRepository;

@Service
@Transactional
public class ModuleService {

	@Autowired
	private CreateModuleRepository createModuleRepository;

	@Autowired
	private ModuleUserParamsRepository moduleRepository;

	@Autowired
	private AccountDAO accRepository;

	@Autowired
	private StepsForTestRepository stepRepository;

	public List<ModuleCreationDb> findAllModules() {
		List<ModuleCreationDb> modules = new ArrayList<>();
		for (ModuleCreationDb module : createModuleRepository.findAll()) {
			modules.add(module);
		}
		return modules;
	}

	public ModuleCreationDb findModule(int id) {
		return createModuleRepository.findOne(id);
	}

	public void save(ModuleCreationDb module) {
		createModuleRepository.save(module);
	}

	public void delete(int id) {
		createModuleRepository.delete(id);
	}

	public void turnMapIntoList(Map<String, Object> paramsMap) {

		String userId = "";
		int moduleId = 0;

		List<ModuleUserParams> paramList = new ArrayList<>();
		Iterator it = paramsMap.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();

			if (pair.getKey().equals("username")) {
				System.out.println(pair.getValue().toString());
				Account acc = accRepository.findByUsername(pair.getValue().toString());
				userId = acc.getId();
			} else if (pair.getKey().equals("moduleID")) {
				System.out.println(pair.getValue());
				moduleId = Integer.valueOf(pair.getValue().toString());
			} else {
				if (!pair.getKey().equals("_csrf")) {
					paramList.add(new ModuleUserParams(pair.getValue().toString()));
				}
			}

			it.remove(); // avoids a ConcurrentModificationException
		}

		StepsForTest step = setTheStepObject(moduleId, userId);

		for (ModuleUserParams mp : paramList) {
			mp.setModuleId(step.getModuleID());
			mp.setStepId(step.getId());
		}

		saveModuleUserParams(paramList);
	}

	public StepsForTest setTheStepObject(int moduleId, String userId) {
		StepsForTest step = new StepsForTest();
		step.setModuleID(moduleId);
		step.setUserUUID(userId);

		saveStepsForTest(step);

		return step;
	}

	public void saveStepsForTest(StepsForTest step) {
		stepRepository.save(step);
	}

	public void saveModuleUserParams(List<ModuleUserParams> paramList) {
		moduleRepository.save(paramList);
	}
}
