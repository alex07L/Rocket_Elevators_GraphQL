package ca.codeboxx.model;

public class Lead {
	
	private final int id;
	private final String fullName;
	private final String entrepriseName;
	private final String cellPhone;
	private final String projectName;
	private final String description;
	private final String type;
	
	public Lead(int id, String fullName, String entrepriseName, String cellPhone, String projectName, String description, String type) {
		this.id=id;
		this.fullName=fullName;
		this.entrepriseName=entrepriseName;
		this.cellPhone=cellPhone;
		this.projectName=projectName;
		this.description=description;
		this.type=type;
	}
	
	public String getCellPhone() {
		return cellPhone;
	}
	public String getDescription() {
		return description;
	}
	
	public String getEntrepriseName() {
		return entrepriseName;
	}
	public String getFullName() {
		return fullName;
	}
	public int getId() {
		return id;
	}
	public String getProjectName() {
		return projectName;
	}
	public String getType() {
		return type;
	}
	

}
