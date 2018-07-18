package app.config.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "MODULECREATIONDB")
public class ModuleCreationDb implements Serializable {

	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String label;
	private String catname;
	private String catdes;
	private String catlink;
	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinColumn(name = "moduleCreationDb_id")
	private List<ParamSettingsDb> params;

	public ModuleCreationDb() {}
	
	public ModuleCreationDb(String label, String catname, String catdes, String catlink, List<ParamSettingsDb> params) {
		this.label = label;
		this.catname = catname;
		this.catdes = catdes;
		this.catlink = catlink;
		this.params = params;
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

	public List<ParamSettingsDb> getParams() {
		return params;
	}

	public void setParams(List<ParamSettingsDb> params) {
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ModuleCreationDb [id=" + id + ", label=" + label + ", catname=" + catname + ", catdes=" + catdes
				+ ", catlink=" + catlink + ", params=" + params + "]";
	}

}
