package ca.codeboxx.model;


public class Intervention {
	
	private final int id;
	private final int author_id;
	private final int customer_id;
	private final int building_id;
	private final int employee_id;
	private final int battery_id;
	private final int column_id;
	private final int elevator_id;
	private final String start_intervention;
	private final String end_intervention;
	private final String status;
	private final String result;
	private final String rapport;
	private final Address address;
	private final Build build;
	
	public Intervention(int id, int customer_id, int author_id, int employee_id, int building_id, int battery_id, int column_id, int elevator_id, String start, String end, Address address, Build build, String status, String result, String rapport) {
		this.id=id;
		this.customer_id=customer_id;
		this.author_id=author_id;
		this.employee_id=employee_id;
		this.building_id=building_id;
		this.start_intervention=start;
		this.end_intervention=end;
		this.address=address;
		this.build=build;
		this.battery_id=battery_id;
		this.column_id=column_id;
		this.elevator_id=elevator_id;
		this.status=status;
		this.rapport=rapport;
		this.result=result;
	}
	
	public int getAuthor_id() {
		return author_id;
	}
	
	public int getCustomer_id() {
		return customer_id;
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
	
	public int getBattery_id() {
		return battery_id;
	}
	public int getColumn_id() {
		return column_id;
	}
	public int getElevator_id() {
		return elevator_id;
	}
	public String getRapport() {
		return rapport;
	}
	public String getResult() {
		return result;
	}
	public String getStatus() {
		return status;
	}

}
