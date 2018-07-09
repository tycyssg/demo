package app.config.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import app.config.dto.InfoToUpdateTheFile;




@Service
public class TaskService{


	@Value("${file.location}")
	private String fileLocation;
	
	@Autowired
	private FileService fileService;
	

	private static ArrayList<InfoToUpdateTheFile> infoList = new ArrayList<>();
	
	
	public String createFileWithExtension(String nameFile,String fileExtension) throws IOException {
		return fileService.createModuleFile(nameFile, fileExtension);
	}
	
	public void createModuleInFile(String fileLocationAndName,List<String> code) {
		fileService.writeModuleCodeInFile(fileLocationAndName, code);
	}
	

    public ArrayList<String> findInfo(String fileName) throws ClassNotFoundException, IOException{
    	ArrayList<String> fileInfo = new ArrayList<>();
    	
    	for(String info : fileService.extractTheProducts(fileName)){
    		fileInfo.add(info);
    	}
    	
    	return fileInfo;
    }
    
    
    
    public void writeInfo(String before,String after,String file,long time) throws IOException {
    	InfoToUpdateTheFile inf = new InfoToUpdateTheFile(after, before, file, time);
    	if(after == null) {
    		inf.setAfter("");
    	}
    	if(before == null) {
    		inf.setBefore("");
    	}
    	
    	infoList.add(inf);
    	
    	File f = new File(fileLocation+file);

    	if(new Date().getTime() - f.lastModified() >= 5000) {
    		Collections.sort(infoList);
    		for(InfoToUpdateTheFile info : infoList) {
    			fileService.writeTheFile(info.getBefore(),info.getAfter(),info.getFile(),fileService.extractTheProducts(info.getFile()));
    		}
    		infoList.clear();
    	}
    }
    
    
	public List<String> getFilesName() {
		List<String> files = new ArrayList<>();
		
		final File folder = new File(fileService.getFileLocation());
		
		for(String file : fileService.listFilesForFolder(folder)) {
			files.add(file);
		}
		
		return files;
	}

	public void getUserStatusAndName(HttpServletRequest request) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		 String currentUserName = "";
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		     currentUserName = authentication.getName();
		    
		}
		if(!(authentication instanceof AnonymousAuthenticationToken) && (authentication.isAuthenticated())) {
			request.setAttribute("login", true);
			request.setAttribute("userLogat", currentUserName);
		}
	}
	
}

