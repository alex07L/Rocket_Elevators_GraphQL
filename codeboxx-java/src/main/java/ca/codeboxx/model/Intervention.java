package ca.codeboxx.model;

import java.util.List;

public class Intervention {
	
	private final int id;
	private final int building_id;
	private final int employee_id;
	private final String start_intervention;
	private final String end_intervention;
	private final Address address;
	private final List<Building_details> building_details;
	
	public Intervention(int id, int employee_id, int building_id, String start, String end, Address address, List<Building_details> building_details) {
		this.id=id;
		this.employee_id=employee_id;
		this.building_id=building_id;
		this.start_intervention=start;
		this.end_intervention=end;
		this.address=address;
		this.building_details=building_details;
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
	
	public List<Building_details> getBuilding_details() {
		return building_details;
	}

}
