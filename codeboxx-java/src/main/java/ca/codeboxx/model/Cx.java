package ca.codeboxx.model;

import java.util.List;

public class Cx {
	
	private final List<Build> build;
	private final List<Battery> battery;
	private final List<Column> column;
	private final List<Elevator> elevator;
	 
	public Cx(List<Build> build,List<Battery> battery,List<Column> column,List<Elevator> elevator) {
		this.battery=battery;
		this.build=build;
		this.column=column;
		this.elevator=elevator;
	}
	
	public List<Battery> getBattery() {
		return battery;
	}
	
	public List<Build> getBuild() {
		return build;
	}
	public List<Column> getColumn() {
		return column;
	}
	public List<Elevator> getElevator() {
		return elevator;
	}

}
