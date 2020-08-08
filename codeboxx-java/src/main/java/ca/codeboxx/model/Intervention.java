package ca.codeboxx.model;

import java.util.List;

public class Intervention {
	
	private final int id;
	private final int building_id;
	private final int employee_id;
	private final String start_intervention;
	private final String end_intervention;
	private final Address address;
	private final Build build;
	
	public Intervention(int id, int employee_id, int building_id, String start, String end, Address address, Build build) {
		this.id=id;
		this.employee_id=employee_id;
		this.building_id=building_id;
		this.start_intervention=start;
		this.end_intervention=end;
		this.address=address;
		this.build=build;
	}
	
	public int getId() {
		return id;
	}
	
	public int getEmployee_id() {
		return employee_id;
	}
	
	public int getBuilding_id() {
		return building_id;
	}
	
	public String getEnd_intervention() {
		return end_intervention;
	}
	
	public String getStart_intervention() {
		return start_intervention;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public Build getBuild() {
		return build;
	}

}
