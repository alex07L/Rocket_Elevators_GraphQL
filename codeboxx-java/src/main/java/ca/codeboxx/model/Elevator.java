package ca.codeboxx.model;

public class Elevator {
	
	private final int id;
	private final String status;
	private final String serialNumber;
	private final String inspectionDate;
	private final String installDate;
	private final String certificat;
	private final String information;
	private final String note;
	private final String type;
	private final int column_id;
	private final int category_id;
	
	public Elevator(int id,String status, String serialNumber, String inspectionDate, String installDate, String certificat, String information, String note, String type, int column_id, int category_id) {
		this.category_id=category_id;
		this.certificat=certificat;
		this.id=id;
		this.status=status;
		this.serialNumber=serialNumber;
		this.inspectionDate=inspectionDate;
		this.installDate=installDate;
		this.information=information;
		this.note=note;
		this.type=type;
		this.column_id=column_id;
	}
	
	public int getCategory_id() {
		return category_id;
	}
	public String getCertificat() {
		return certificat;
	}
	public int getColumn_id() {
		return column_id;
	}
	public int getId() {
		return id;
	}
	public String getInformation() {
		return information;
	}
	public String getInspectionDate() {
		return inspectionDate;
	}
	public String getInstallDate() {
		return installDate;
	}
	
	public String getNote() {
		return note;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public String getStatus() {
		return status;
	}
	public String getType() {
		return type;
	}

}
