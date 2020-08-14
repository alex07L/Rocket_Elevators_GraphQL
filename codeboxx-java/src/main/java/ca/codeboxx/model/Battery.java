package ca.codeboxx.model;

public class Battery {
	
	private final int id;
	private final String status;
	
	public Battery(int id, String status) {
		this.id=id;
		this.status=status;
	}
	
	public int getId() {
		return id;
	}
	public String getStatus() {
		return status;
	}

}
