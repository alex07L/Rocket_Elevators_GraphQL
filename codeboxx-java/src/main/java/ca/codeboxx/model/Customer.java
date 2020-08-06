package ca.codeboxx.model;

public class Customer {
	
	private final String entrepriseName;
	private final String nameContact;
	private final String cellPhone;
	private final String email;
	private final String description;
	private final String authorityName;
	private final String authorityPhone;
	private final String authorityEmail;
	private final Address address;
	
	
	public Customer(String entrepriseName,String nameContact, String cellPhone, String description, String email, String authorityName, String authorityPhone, String authorityEmail, Address address) {
		this.entrepriseName=entrepriseName;
		this.nameContact=nameContact;
		this.cellPhone=cellPhone;
		this.email=email;
		this.description=description;
		this.authorityName=authorityName;
		this.authorityEmail=authorityEmail;
		this.authorityPhone=authorityPhone;
		this.address=address;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getAuthorityEmail() {
		return authorityEmail;
	}
	
	public String getAuthorityName() {
		return authorityName;
	}
	
	public String getAuthorityPhone() {
		return authorityPhone;
	}
	
	public String getCellPhone() {
		return cellPhone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getEntrepriseName() {
		return entrepriseName;
	}
	
	public String getNameContact() {
		return nameContact;
	}

}
