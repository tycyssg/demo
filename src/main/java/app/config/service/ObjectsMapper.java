package app.config.service;

import org.springframework.stereotype.Service;

import app.config.dto.ModuleCreation;
import app.config.dto.ParamSettings;
import app.config.model.ModuleCreationDb;
import app.config.model.ParamSettingsDb;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

@Service
public class ObjectsMapper {
	
	public ObjectsMapper() {}
	
	private static MapperFacade mapper;
	
	static {
		final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
			mapperFactory.classMap(ModuleCreation.class,ModuleCreationDb.class)
			.byDefault().register();
			mapper = mapperFactory.getMapperFacade();
	}
	
	public ParamSettingsDb mapParamSettings(final ParamSettings modelParamSettings) {
		return mapper.map(modelParamSettings, ParamSettingsDb.class);
	}

	
	
}
