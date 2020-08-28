package ca.codeboxx.model;

public class Column {
	
	private final int id;
	private final int battery_id;
	private final String status;
	
	public Column(int id, int battery_id, String status) {
		this.id=id;
		this.battery_id=battery_id;
		this.status=status;
	}
	
	public int getBattery_id() {
		return battery_id;
	}
	
	public int getId() {
		return id;
	}
	public String getStatus() {
		return status;
	}

}
