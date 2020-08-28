package ca.codeboxx.model;

public class Battery {
	
	private final int id;
	private final int build_id;
	private final String status;
	
	public Battery(int id, int build_id, String status) {
		this.id=id;
		this.build_id=build_id;
		this.status=status;
	}
	
	public int getId() {
		return id;
	}
	public String getStatus() {
		return status;
	}

}
