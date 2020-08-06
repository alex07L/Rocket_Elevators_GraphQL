package ca.codeboxx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ca.codeboxx.model.Address;
import ca.codeboxx.model.Building;
import ca.codeboxx.model.Building_details;
import ca.codeboxx.model.Customer;
import ca.codeboxx.model.Employee;
import ca.codeboxx.model.Intervention;

public class Database {

	private Connection mysql;
	private Connection postgresql;

	public Database(String url, String user, String password, String urlPost, String userPost, String passwordPost) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			mysql = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			Class.forName("org.postgresql.Driver");
			postgresql = DriverManager.getConnection(urlPost, userPost, passwordPost);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void close() {

		try {
			mysql.close();
			postgresql.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Building_details> getBuildingDetails(int building_id){
		List<Building_details> building_details = new ArrayList<Building_details>();
		PreparedStatement m;
		try {
			m = mysql.prepareStatement(
					"SELECT b.infoKey, b.infoValue FROM building_details b WHERE b.building_id="
							+ building_id);
			// Execute the Query, and get a java ResultSet
			ResultSet rs2 = m.executeQuery();
			// Let's iterate through the java ResultSet
			while (rs2.next()) {
				//new Building_details(id, key, value)
				building_details.add(new Building_details(rs2.getString("infoKey"), rs2.getString("infoValue")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return building_details;
	}

	public Intervention getIntervention(int id) {
		Intervention i = null;
		PreparedStatement state = null;
		try {

			state = postgresql.prepareStatement(
					"SELECT employee_id, building_id, start_intervention, end_intervention FROM factintervention WHERE id="
							+ id);

			// Execute the Query, and get a java ResultSet
			ResultSet rs = state.executeQuery();
			// Let's iterate through the java ResultSet
			if (rs.next()) {
				int building_id = rs.getInt("building_id");
				PreparedStatement m = mysql.prepareStatement(
						"SELECT a.street, a.suite, a.city, a.postalCode, a.country FROM buildings b JOIN addresses a ON a.id=b.address_id WHERE b.id="
								+ building_id);

				// Execute the Query, and get a java ResultSet
				ResultSet rs2 = m.executeQuery();
				// Let's iterate through the java ResultSet
				if (rs2.next()) {
					i = new Intervention(id, rs.getInt("employee_id"), building_id, rs.getString("start_intervention"),
							rs.getString("end_intervention"),
							new Address(rs2.getString("street"), rs2.getString("suite"), rs2.getString("city"),
									rs2.getString("postalCode"), rs2.getString("country")),getBuildingDetails(building_id));

				}
			}

		} catch (

		SQLException e) {
			e.printStackTrace();
		}
		close();
		return i;

	}

	public Building getBuilding(int id) {
		Building i = null;
		PreparedStatement state = null;
		try {

			state = postgresql.prepareStatement(
					"SELECT id, employee_id, building_id, start_intervention, end_intervention FROM factintervention WHERE building_id="
							+ id);

			// Execute the Query, and get a java ResultSet
			ResultSet rs = state.executeQuery();
			// Let's iterate through the java ResultSet
			List<Intervention> l = new ArrayList<Intervention>();
			Address a = null;
			Customer c = null;
			List<Building_details> bb = getBuildingDetails(id);
			if (rs.next()) {
				PreparedStatement m = mysql.prepareStatement(
						"SELECT a.street, a.suite, a.city, a.postalCode, a.country,c.entrepriseName , c.nameContact ,c.description, c.email, c.cellPhone ,c.authorityEmail ,c.authorityName, c.authorityPhone, a2.street AS 'Cstreet', a2.suite AS 'Csuite', a2.city AS 'Ccity', a2.postalCode AS 'CpostalCode', a2.country AS 'Ccountry' FROM buildings b JOIN addresses a ON a.id=b.address_id JOIN customers c ON c.id= b.customer_id JOIN addresses a2 ON a2.id=c.address_id WHERE b.id="
								+ id);

				// Execute the Query, and get a java ResultSet
				ResultSet rs2 = m.executeQuery();
				// Let's iterate through the java ResultSet
				if (rs2.next()) {
					c = new Customer(rs2.getString("entrepriseName"), rs2.getString("nameContact"),
							rs2.getString("cellPhone"), rs2.getString("description"),
							rs2.getString("email"), rs2.getString("authorityName"),
							rs2.getString("authorityPhone"), rs2.getString("authorityEmail"),
							new Address(rs2.getString("Cstreet"), rs2.getString("Csuite"), rs2.getString("Ccity"),
									rs2.getString("CpostalCode"), rs2.getString("Ccountry")));
					a = new Address(rs2.getString("street"), rs2.getString("suite"), rs2.getString("city"),
							rs2.getString("postalCode"), rs2.getString("country"));
					l.add(new Intervention(rs.getInt("id"), rs.getInt("employee_id"), id, rs.getString("start_intervention"),
							rs.getString("end_intervention"), a, bb));

				}
			}
			while (rs.next()) {
				l.add(new Intervention(rs.getInt("id"), rs.getInt("employee_id"), id, rs.getString("start_intervention"),
						rs.getString("end_intervention"), a, bb));
			}
			i = new Building(id, a, c, l);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return i;

	}
	
	public Employee getEmployee(int id) {
		Employee i = null;
		PreparedStatement state = null;
		try {

			state = postgresql.prepareStatement(
					"SELECT id, employee_id, building_id, start_intervention, end_intervention FROM factintervention WHERE employee_id="
							+ id);

			// Execute the Query, and get a java ResultSet
			ResultSet rs = state.executeQuery();
			// Let's iterate through the java ResultSet
			List<Intervention> l = new ArrayList<Intervention>();
			Address a = null;
			
			if (rs.next()) {
				PreparedStatement m = mysql.prepareStatement(
						"SELECT a.street, a.suite, a.city, a.postalCode, a.country FROM buildings b JOIN addresses a ON a.id=b.address_id WHERE b.id="
								+ rs.getInt("building_id"));

				// Execute the Query, and get a java ResultSet
				ResultSet rs2 = m.executeQuery();
				// Let's iterate through the java ResultSet
				if (rs2.next()) {
					a = new Address(rs2.getString("street"), rs2.getString("suite"), rs2.getString("city"),
							rs2.getString("postalCode"), rs2.getString("country"));
					l.add(new Intervention(rs.getInt("id"), rs.getInt("employee_id"), rs.getInt("building_id"), rs.getString("start_intervention"),
							rs.getString("end_intervention"), a, getBuildingDetails(rs.getInt("building_id"))));

				}
			}
			while (rs.next()) {
				l.add(new Intervention(rs.getInt("id"), rs.getInt("employee_id"), rs.getInt("building_id"), rs.getString("start_intervention"),
						rs.getString("end_intervention"), a,  getBuildingDetails(rs.getInt("building_id"))));
			}
			
			PreparedStatement employee = mysql.prepareStatement(
					"SELECT email, firstName, lastName, title FROM employees WHERE id="+ id);

			// Execute the Query, and get a java ResultSet
			ResultSet rs3 = employee.executeQuery();
			// Let's iterate through the java ResultSet
			if (rs3.next()) {
				i = new Employee(id, rs3.getString("firstName"), rs3.getString("lastName"), rs3.getString("email"), rs3.getString("title"), l);
			}

		} catch (

		SQLException e) {
			e.printStackTrace();
		}
		close();
		return i;
	}

}
