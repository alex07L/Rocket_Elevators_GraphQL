package ca.codeboxx.model;

import java.util.List;

public class Building {
	
	private final int id;
	private final Address address;
	private final Customer customer;
	private final List<Intervention> interventions;
	
	public Building(int id, Address address, Customer customer, List<Intervention> interventions) {
		this.id=id;
		this.address=address;
		this.customer=customer;
		this.interventions=interventions;
	}
	
	public Address getAddress() {
		return address;
	}
	public Customer getCustomer() {
		return customer;
	}
	
	public int getId() {
		return id;
	}
	
	public List<Intervention> getInterventions() {
		return interventions;
	}

}
