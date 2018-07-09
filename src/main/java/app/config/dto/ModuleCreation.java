package app.config.dto;

import java.util.List;

public class ModuleCreation {

	private String label;
	private String catname;
	private String catdes;
	private String catlink;
	private String fileextension;
	private List<String> catcode;
	private List<ParamSettings> params;

	public ModuleCreation() {
	}


	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getCatname() {
		return catname;
	}

	public void setCatname(String catname) {
		this.catname = catname;
	}

	public String getFileextension() {
		return fileextension;
	}

	public void setFileextension(String fileextension) {
		this.fileextension = fileextension;
	}

	public List<String> getCatcode() {
		return catcode;
	}

	public void setCatcode(List<String> catcode) {
		this.catcode = catcode;
	}

	public List<ParamSettings> getParams() {
		return params;
	}

	public void setParams(List<ParamSettings> params) {
		this.params = params;
	}

	public String getCatlink() {
		return catlink;
	}

	public void setCatlink(String catlink) {
		this.catlink = catlink;
	}

	
	public String getCatdes() {
		return catdes;
	}


	public void setCatdes(String catdes) {
		this.catdes = catdes;
	}


	@Override
	public String toString() {
		return "ModuleCreationDb [label=" + label + ", catname=" + catname + ", catdes=" + catdes + ", catlink=" + catlink
				+ ", fileextension=" + fileextension + ", catcode=" + catcode + ", params=" + params + "]";
	}





}
