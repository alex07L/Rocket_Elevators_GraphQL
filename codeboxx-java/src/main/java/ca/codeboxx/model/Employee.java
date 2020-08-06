package ca.codeboxx.model;

import java.util.List;

public class Employee {

	private final int id;
	private final String firstName;
	private final String lastName;
	private final String email;
	private final String title;
	private final List<Intervention> interventions;
	
	public Employee(int id, String firstName, String lastName, String email, String title, List<Intervention> interventions) {
		this.id=id;
		this.firstName=firstName;
		this.lastName=lastName;
		this.email=email;
		this.title=title;
		this.interventions=interventions;
		
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public int getId() {
		return id;
	}
	public List<Intervention> getInterventions() {
		return interventions;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getTitle() {
		return title;
	}
}
