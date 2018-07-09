//package app.config.dao;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//
//@Entity
//public class AddingModule {
//	
//	@Id
//	@GeneratedValue
//	private int id;
//	private String category;
//	private String name;
//	private String description;
//	private String pageLink;
//	private String tutorialLink;
//	private int paramFields;
//	private String paramFieldName;
//	
//	public AddingModule() {}
//	
//
//
//	public AddingModule(String category, String name, String description, String pageLink, String tutorialLink,
//			int paramFields, String paramFieldName) {
//		super();
//		this.category = category;
//		this.name = name;
//		this.description = description;
//		this.pageLink = pageLink;
//		this.tutorialLink = tutorialLink;
//		this.paramFields = paramFields;
//		this.paramFieldName = paramFieldName;
//	}
//
//
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getCategory() {
//		return category;
//	}
//
//	public void setCategory(String category) {
//		this.category = category;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//
//	public String getPageLink() {
//		return pageLink;
//	}
//
//	public void setPageLink(String pageLink) {
//		this.pageLink = pageLink;
//	}
//
//	public String getTutorialLink() {
//		return tutorialLink;
//	}
//
//	public void setTutorialLink(String tutorialLink) {
//		this.tutorialLink = tutorialLink;
//	}
//
//	public int getParamFields() {
//		return paramFields;
//	}
//
//	public void setParamFields(int paramFields) {
//		this.paramFields = paramFields;
//	}
//
//	
//	public String getParamFieldName() {
//		return paramFieldName;
//	}
//
//
//
//	public void setParamFieldName(String paramFieldName) {
//		this.paramFieldName = paramFieldName;
//	}
//
//
//
//	@Override
//	public String toString() {
//		return "AddingModule [id=" + id + ", category=" + category + ", name=" + name + ", description=" + description
//				+ ", pageLink=" + pageLink + ", tutorialLink=" + tutorialLink + ", paramFields=" + paramFields + "]";
//	}
//	
//	
//	
//
//}
