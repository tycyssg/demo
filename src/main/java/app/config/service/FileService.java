package app.config.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FileService {
	
	@Value("${file.location}")
	private String fileLocation;
	
	@Value("${module.creation}")
	private String moduleLocation;
	
	
	public String createModuleFile(String fileName,String fileExtension) throws IOException {
		
			String fNameTrim = fileName.toLowerCase().trim();
			String fNameReplace = fNameTrim.replaceAll("\\s+","_");
			String finalFileName = moduleLocation+fNameReplace+fileExtension;
		
			File f = new File(finalFileName);
			if(!f.exists()){
			  f.createNewFile();
			}else{
			  System.out.println("File already exists");
			}
			
			return finalFileName;

	}
	
	
public void writeModuleCodeInFile(String fileLocationAndName,List<String> code) {
		
		BufferedWriter bw = null;
		FileWriter fw = null;
		
		try {

			fw = new FileWriter(fileLocationAndName);
			bw = new BufferedWriter(fw);

			for(int i = 0 ; i < code.size();i++) {
			
				bw.write(code.get(i));
				bw.newLine();
			
		}
		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		}
	}
	
	public ArrayList<String> extractTheProducts(String fileName) throws IOException{
		
		ArrayList<String> list = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(fileLocation+fileName))) {

			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				list.add(sCurrentLine);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	
	public void writeTheFile(String before,String after,String fileName,ArrayList<String> list) {
		
		BufferedWriter bw = null;
		FileWriter fw = null;
		
		try {

			fw = new FileWriter(fileLocation+fileName);
			bw = new BufferedWriter(fw);

			boolean allow = true;
			
			for(int i = 0 ; i < list.size();i++) {
				if(allow) {	//if two lines are the same edite only one.
			if(before.trim().equals(list.get(i))) {
					list.set(i, after.trim());
					allow = false;
				}
			}
				bw.write(list.get(i));
				bw.newLine();
			
		}
		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		}
	}
	
	
	public void createFile() throws IOException {		
		File f = new File(fileLocation+"language.txt");
		if(!f.exists()){
		  f.createNewFile();
		}else{
		  System.out.println("File already exists");
		}
	}
	
	
	
	public String getFileLocation() {
		return fileLocation;
	}



	public  List<String> listFilesForFolder(final File folder) {
		List<String> files = new ArrayList<>();
	    for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	            listFilesForFolder(fileEntry);
	        } else {
	          files.add(fileEntry.getName());
	        }
	    }
	    return files;
	}
}
