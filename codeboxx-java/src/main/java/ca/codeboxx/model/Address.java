package ca.codeboxx.model;

public class Address {
	
	private final String street;
	private final String suite;
	private final String city;
	private final String postalCode;
	private final String country;
	
	public Address(String street, String suite, String city, String postalCode, String country) {
		this.street = street;
		this.suite=suite;
		this.city=city;
		this.postalCode=postalCode;
		this.country=country;
		
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
