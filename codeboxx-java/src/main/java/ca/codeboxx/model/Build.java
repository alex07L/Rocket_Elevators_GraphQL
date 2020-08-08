package ca.codeboxx.model;

import java.util.List;

public class Build {

	private final int id;
	private final String fullName;
	private final String email;
	private final String cellPhone;
	private final String techName;
	private final String techEmail;
	private final Address address;
	private final int customer_id;
	private final List<Building_details> building_details;
	
	public Build(int id, String fullname, String email, String cellPhone, String techName, String techEmail, Address address, int customer_id, List<Building_details> building_details) {
		this.building_details=building_details;
		this.address=address;
		this.id=id;
		this.fullName=fullname;
		this.email=email;
		this.cellPhone=cellPhone;
		this.techEmail=techEmail;
		this.techName=techName;
		this.customer_id=customer_id;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public List<Building_details> getBuilding_details() {
		return building_details;
	}
	
	public String getCellPhone() {
		return cellPhone;
	}
	
	public int getCustomer_id() {
		return customer_id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	public int getId() {
		return id;
	}
	
	public String getTechEmail() {
		return techEmail;
	}
	public String getTechName() {
		return techName;
	}

}
