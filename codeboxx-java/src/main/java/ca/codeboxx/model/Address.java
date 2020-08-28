package ca.codeboxx.model;

public class Address {
	
	private final int id;
	private final String street;
	private final String suite;
	private final String city;
	private final String postalCode;
	private final String country;
	
	public Address(int id,String street, String suite, String city, String postalCode, String country) {
		this.id=id;
		this.street = street;
		this.suite=suite;
		this.city=city;
		this.postalCode=postalCode;
		this.country=country;
		
	}
	
	public int getId() {
		return id;
	}
	
	public String getStreet() {
		return street;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getCountry() {
		return country;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	
	public String getSuite() {
		return suite;
	}

}
