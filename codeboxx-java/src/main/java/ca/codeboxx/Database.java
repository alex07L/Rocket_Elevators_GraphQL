package ca.codeboxx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ca.codeboxx.model.Address;
import ca.codeboxx.model.Battery;
import ca.codeboxx.model.Build;
import ca.codeboxx.model.Building;
import ca.codeboxx.model.Building_details;
import ca.codeboxx.model.Column;
import ca.codeboxx.model.Customer;
import ca.codeboxx.model.Elevator;
import ca.codeboxx.model.Employee;
import ca.codeboxx.model.Intervention;
import ca.codeboxx.model.Lead;

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

	public List<Building_details> getBuildingDetails(int building_id) {
		List<Building_details> building_details = new ArrayList<Building_details>();
		PreparedStatement m;
		try {
			m = mysql.prepareStatement(
					"SELECT b.infoKey, b.infoValue FROM building_details b WHERE b.building_id=" + building_id);
			// Execute the Query, and get a java ResultSet
			ResultSet rs2 = m.executeQuery();
			// Let's iterate through the java ResultSet
			while (rs2.next()) {
				// new Building_details(id, key, value)
				building_details.add(new Building_details(rs2.getString("infoKey"), rs2.getString("infoValue")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return building_details;
	}

	public Build getBuild(int building_id) {
		Build d = null;
		PreparedStatement m;
		try {
			m = mysql.prepareStatement(
					"SELECT b.id, b.fullName,b.email,b.cellPhone,b.techName,b.techPhone,b.techEmail,b.customer_id, a.street, a.suite, a.city, a.postalCode, a.country FROM buildings b JOIN addresses a ON b.address_id=a.id WHERE b.id="
							+ building_id);
			// Execute the Query, and get a java ResultSet
			ResultSet rs2 = m.executeQuery();
			// Let's iterate through the java ResultSet
			if (rs2.next()) {
				d = new Build(rs2.getInt("id"), rs2.getString("fullName"), rs2.getString("email"),
						rs2.getString("cellPhone"), rs2.getString("techName"), rs2.getString("techEmail"),
						rs2.getString("techPhone"),
						new Address(rs2.getString("street"), rs2.getString("suite"), rs2.getString("city"),
								rs2.getString("postalCode"), rs2.getString("country")),
						rs2.getInt("customer_id"), getBuildingDetails(building_id));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}

	public Intervention getIntervention(int id) {
		Intervention i = null;
		PreparedStatement state = null;
		try {

			state = postgresql.prepareStatement(
					"SELECT employee_id, building_id, battery_id, column_id, elevator_id, start_intervention, end_intervention, status, resultat, rapport FROM factintervention WHERE id="
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
					i = new Intervention(id, 0, 0, rs.getInt("employee_id"), rs.getInt("building_id"),
							rs.getInt("battery_id"), rs.getInt("column_id"), rs.getInt("elevator_id"),
							rs.getString("start_intervention"), rs.getString("end_intervention"),
							new Address(rs2.getString("street"), rs2.getString("suite"), rs2.getString("city"),
									rs2.getString("postalCode"), rs2.getString("country")),
							getBuild(building_id), rs.getString("status"), rs.getString("resultat"),
							rs.getString("rapport"));

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
					"SELECT id, employee_id, building_id, start_intervention, end_intervention, battery_id, column_id, elevator_id,resultat,rapport,status FROM factintervention WHERE building_id="
							+ id);

			// Execute the Query, and get a java ResultSet
			ResultSet rs = state.executeQuery();
			// Let's iterate through the java ResultSet
			List<Intervention> l = new ArrayList<Intervention>();
			Address a = null;
			Customer c = null;
			Build bb = getBuild(id);
			if (rs.next()) {
				PreparedStatement m = mysql.prepareStatement(
						"SELECT a.street, a.suite, a.city, a.postalCode, a.country,c.entrepriseName , c.nameContact ,c.description, c.email, c.cellPhone ,c.authorityEmail ,c.authorityName, c.authorityPhone, a2.street AS 'Cstreet', a2.suite AS 'Csuite', a2.city AS 'Ccity', a2.postalCode AS 'CpostalCode', a2.country AS 'Ccountry' FROM buildings b JOIN addresses a ON a.id=b.address_id JOIN customers c ON c.id= b.customer_id JOIN addresses a2 ON a2.id=c.address_id WHERE b.id="
								+ id);

				// Execute the Query, and get a java ResultSet
				ResultSet rs2 = m.executeQuery();
				// Let's iterate through the java ResultSet
				if (rs2.next()) {
					c = new Customer(rs2.getString("entrepriseName"), rs2.getString("nameContact"),
							rs2.getString("cellPhone"), rs2.getString("description"), rs2.getString("email"),
							rs2.getString("authorityName"), rs2.getString("authorityPhone"),
							rs2.getString("authorityEmail"),
							new Address(rs2.getString("Cstreet"), rs2.getString("Csuite"), rs2.getString("Ccity"),
									rs2.getString("CpostalCode"), rs2.getString("Ccountry")));
					a = new Address(rs2.getString("street"), rs2.getString("suite"), rs2.getString("city"),
							rs2.getString("postalCode"), rs2.getString("country"));
					l.add(new Intervention(rs.getInt("id"), 0, 0, rs.getInt("employee_id"), id, rs.getInt("battery_id"),
							rs.getInt("column_id"), rs.getInt("elevator_id"), rs.getString("start_intervention"),
							rs.getString("end_intervention"), a, bb, rs.getString("status"), rs.getString("resultat"),
							rs.getString("rapport")));

				}
			}
			while (rs.next()) {
				l.add(new Intervention(rs.getInt("id"), 0, 0, rs.getInt("employee_id"), id, rs.getInt("battery_id"),
						rs.getInt("column_id"), rs.getInt("elevator_id"), rs.getString("start_intervention"),
						rs.getString("end_intervention"), a, bb, rs.getString("status"), rs.getString("resultat"),
						rs.getString("rapport")));
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
					"SELECT id, employee_id, building_id, battery_id, column_id, elevator_id, start_intervention, end_intervention, rapport, status, resultat FROM factintervention WHERE employee_id="
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
					l.add(new Intervention(rs.getInt("id"), 0, 0, rs.getInt("employee_id"), rs.getInt("building_id"),
							rs.getInt("battery_id"), rs.getInt("column_id"), rs.getInt("elevator_id"),
							rs.getString("start_intervention"), rs.getString("end_intervention"), a,
							getBuild(rs.getInt("building_id")), rs.getString("status"), rs.getString("resultat"),
							rs.getString("rapport")));

				}
			}
			while (rs.next()) {
				l.add(new Intervention(rs.getInt("id"), 0, 0, rs.getInt("employee_id"), rs.getInt("building_id"),
						rs.getInt("battery_id"), rs.getInt("column_id"), rs.getInt("elevator_id"),
						rs.getString("start_intervention"), rs.getString("end_intervention"), a,
						getBuild(rs.getInt("building_id")), rs.getString("status"), rs.getString("resultat"),
						rs.getString("rapport")));
			}

			PreparedStatement employee = mysql
					.prepareStatement("SELECT email, firstName, lastName, title FROM employees WHERE id=" + id);

			// Execute the Query, and get a java ResultSet
			ResultSet rs3 = employee.executeQuery();
			// Let's iterate through the java ResultSet
			if (rs3.next()) {
				i = new Employee(id, rs3.getString("firstName"), rs3.getString("lastName"), rs3.getString("email"),
						rs3.getString("title"), l);
			}

		} catch (

		SQLException e) {
			e.printStackTrace();
		}
		close();
		return i;
	}

	public List<Intervention> getInterventionList() {
		List<Intervention> is = new ArrayList<Intervention>();
		PreparedStatement state = null;
		try {

			state = mysql.prepareStatement(
					"SELECT id, employee_id,customer_id, building_id, battery_id, column_id, elevator_id, start_intervention, end_intervention, status, result, rapport FROM interventions WHERE start_intervention IS NULL AND status='pending'");

			// Execute the Query, and get a java ResultSet
			ResultSet rs = state.executeQuery();
			// Let's iterate through the java ResultSet
			while (rs.next()) {
				int building_id = rs.getInt("building_id");
				PreparedStatement m = mysql.prepareStatement(
						"SELECT a.street, a.suite, a.city, a.postalCode, a.country FROM buildings b JOIN addresses a ON a.id=b.address_id WHERE b.id="
								+ building_id);

				// Execute the Query, and get a java ResultSet
				ResultSet rs2 = m.executeQuery();
				// Let's iterate through the java ResultSet
				if (rs2.next()) {
					is.add(new Intervention(rs.getInt("id"), rs.getInt("customer_id"), 0, rs.getInt("employee_id"),
							rs.getInt("building_id"), rs.getInt("battery_id"), rs.getInt("column_id"),
							rs.getInt("elevator_id"), rs.getString("start_intervention"),
							rs.getString("end_intervention"),
							new Address(rs2.getString("street"), rs2.getString("suite"), rs2.getString("city"),
									rs2.getString("postalCode"), rs2.getString("country")),
							getBuild(building_id), rs.getString("status"), rs.getString("result"),
							rs.getString("rapport")));

				}
			}

		} catch (

		SQLException e) {
			e.printStackTrace();
		}
		close();
		return is;

	}

	public Intervention updateIntervention(int id, String status) {
		Intervention i = null;
		PreparedStatement state = null;
		try {
			PreparedStatement s = null;
			if (status.equalsIgnoreCase("inprogress")) {
				s = mysql.prepareStatement(
						"UPDATE interventions i SET i.status= ?, start_intervention=CURRENT_TIMESTAMP() WHERE i.id = ?;");
			} else if (status.equalsIgnoreCase("complete")) {
				s = mysql.prepareStatement(
						"UPDATE interventions i SET i.status= ?, end_intervention=CURRENT_TIMESTAMP() WHERE i.id = ?;");
			}
			if (s != null) {
				s.setString(1, status);
				s.setInt(2, id);
				s.executeUpdate();
			}

			state = mysql.prepareStatement(
					"SELECT id, customer_id, employee_id, building_id, battery_id, column_id, elevator_id, start_intervention, end_intervention, status, result, rapport FROM interventions WHERE id="
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
					i = new Intervention(id, rs.getInt("customer_id"), 0, rs.getInt("employee_id"),
							rs.getInt("building_id"), rs.getInt("battery_id"), rs.getInt("column_id"),
							rs.getInt("elevator_id"), rs.getString("start_intervention"),
							rs.getString("end_intervention"),
							new Address(rs2.getString("street"), rs2.getString("suite"), rs2.getString("city"),
									rs2.getString("postalCode"), rs2.getString("country")),
							getBuild(building_id), rs.getString("status"), rs.getString("result"),
							rs.getString("rapport"));

				}
			}

		} catch (

		SQLException e) {
			e.printStackTrace();
		}
		close();
		return i;

	}

	public Battery getBattery(int id) {
		Battery b = null;
		PreparedStatement s = null;
		try {
			s = mysql.prepareStatement(
					"SELECT b.id, s.name FROM batteries b JOIN statuses s ON b.status_id=s.id WHERE b.id =" + id);
			ResultSet rs = s.executeQuery();
			if (rs.next()) {
				b = new Battery(rs.getInt("id"), rs.getString("name"));
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		close();
		return b;
	}

	public Battery updateBattery(int id, String status) {
		PreparedStatement s = null;
		try {
			s = mysql.prepareStatement(
					"UPDATE batteries b SET b.status_id = (SELECT s.id FROM statuses s WHERE s.name=?) WHERE b.id = ?;");
			s.setString(1, status);
			s.setInt(2, id);
			s.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		}

		return getBattery(id);
	}

	public Column getColumn(int id) {
		Column b = null;
		PreparedStatement s = null;
		try {
			s = mysql.prepareStatement(
					"SELECT c.id, s.name FROM columns c JOIN statuses s ON c.status_id=s.id WHERE c.id = " + id);
			ResultSet rs = s.executeQuery();
			if (rs.next()) {
				b = new Column(rs.getInt("id"), rs.getString("name"));
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		close();
		return b;
	}

	public Column updateColumn(int id, String status) {
		PreparedStatement s = null;
		try {
			s = mysql.prepareStatement(
					"UPDATE columns c SET c.status_id = (SELECT s.id FROM statuses s WHERE s.name=?) WHERE c.id = ?;");
			s.setString(1, status);
			s.setInt(2, id);
			s.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		}

		return getColumn(id);
	}

	public List<Lead> getLead() {
		List<Lead> ls = new ArrayList<Lead>();
		PreparedStatement s = null;
		try {
			s = mysql.prepareStatement(
					"SELECT DISTINCT l.id, l.fullName, l.entrepriseName, l.cellPhone, l.projectName, l.description, t.name FROM leads l JOIN customers c ON c.email!=l.email JOIN types t ON t.id=l.type_id WHERE DATEDIFF(l.created_at,CURDATE()) <= 30;");
			ResultSet rs = s.executeQuery();
			while (rs.next()) {
				ls.add(new Lead(rs.getInt("id"), rs.getString("fullName"), rs.getString("entrepriseName"),
						rs.getString("cellPhone"), rs.getString("projectName"), rs.getString("description"),
						rs.getString("name")));
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		close();
		return ls;
	}

	public List<Elevator> getElevatorList() {
		List<Elevator> ls = new ArrayList<Elevator>();
		PreparedStatement s = null;
		try {
			s = mysql.prepareStatement(
					"SELECT e.id, s.name as 'status', e.serialNumber, e.inspectionDate, e.installDate, e.certificat, e.information, e.note, t.name AS 'type', e.column_id, e.category_id FROM elevators e JOIN statuses s ON s.id=e.status_id JOIN types t ON t.id=e.type_id WHERE s.name !='active';");
			ResultSet rs = s.executeQuery();
			while (rs.next()) {

				ls.add(new Elevator(rs.getInt("id"), rs.getString("status"), rs.getString("serialNumber"),
						rs.getString("inspectionDate"), rs.getString("installDate"), rs.getString("certificat"),
						rs.getString("information"), rs.getString("note"), rs.getString("type"), rs.getInt("column_id"),
						rs.getInt("category_id")));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
		return ls;
	}

	public Elevator getElevator(int id) {
		Elevator ls = null;
		PreparedStatement s = null;
		try {
			s = mysql.prepareStatement(
					"SELECT e.id, s.name AS 'status', e.serialNumber, e.inspectionDate, e.installDate, e.certificat, e.information, e.note, t.name AS 'type', e.column_id, e.category_id FROM elevators e JOIN statuses s ON s.id=e.status_id JOIN types t ON t.id=e.type_id WHERE e.id ="
							+ id);
			ResultSet rs = s.executeQuery();
			if (rs.next()) {
				ls = new Elevator(rs.getInt("id"), rs.getString("status"), rs.getString("serialNumber"),
						rs.getString("inspectionDate"), rs.getString("installDate"), rs.getString("certificat"),
						rs.getString("information"), rs.getString("note"), rs.getString("type"), rs.getInt("column_id"),
						rs.getInt("category_id"));
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		close();
		return ls;
	}

	public Elevator updateElevator(int id, String status) {
		PreparedStatement s = null;
		try {
			s = mysql.prepareStatement(
					"UPDATE elevators e SET e.status_id = (SELECT s.id FROM statuses s WHERE s.name=?) WHERE e.id = ?");
			s.setString(1, status);
			s.setInt(2, id);
			s.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		}

		return getElevator(id);
	}

	public List<Build> getBuildIntervention() {
		List<Build> b = new ArrayList<Build>();
		PreparedStatement s = null;
		try {
			s = mysql.prepareStatement(
					"SELECT DISTINCT b.id, b.fullName, b.cellPhone, b.email,b.techEmail, b.techName, b.techPhone, b.customer_id, a.street, a.suite, a.city, a.postalCode, a.country FROM buildings b JOIN batteries b2 ON b2.building_id=b.id JOIN addresses a ON a.id=b.address_id JOIN `columns` c ON b2.id=c.battery_id JOIN elevators e ON e.column_id=c.id WHERE b2.status_id=(SELECT s2.id FROM statuses s2 WHERE s2.name='intervention') OR c.status_id=(SELECT s2.id FROM statuses s2 WHERE s2.name='intervention') OR e.status_id=(SELECT s2.id FROM statuses s2 WHERE s2.name='intervention');");
			ResultSet rs = s.executeQuery();
			while (rs.next()) {
				b.add(new Build(rs.getInt("id"), rs.getString("fullName"), rs.getString("email"),
						rs.getString("cellPhone"), rs.getString("techName"), rs.getString("techEmail"),
						rs.getString("techPhone"),
						new Address(rs.getString("street"), rs.getString("suite"), rs.getString("city"),
								rs.getString("postalCode"), rs.getString("country")),
						rs.getInt("customer_id"), getBuildingDetails(rs.getInt("id"))));
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		close();
		return b;
	}

	public Customer getCustomer(String email) {
		Customer c = null;

		try {
			PreparedStatement m = mysql.prepareStatement(
					"SELECT a.street, a.suite, a.city, a.postalCode, a.country,c.entrepriseName , c.nameContact ,c.description, c.email, c.cellPhone ,c.authorityEmail ,c.authorityName, c.authorityPhone, a2.street AS 'Cstreet', a2.suite AS 'Csuite', a2.city AS 'Ccity', a2.postalCode AS 'CpostalCode', a2.country AS 'Ccountry' FROM buildings b JOIN addresses a ON a.id=b.address_id JOIN customers c ON c.id= b.customer_id JOIN addresses a2 ON a2.id=c.address_id WHERE c.email="
							+ email);

			// Execute the Query, and get a java ResultSet
			ResultSet rs2 = m.executeQuery();
			if (rs2.next()) {
				c = new Customer(rs2.getString("entrepriseName"), rs2.getString("nameContact"), rs2.getString("cellPhone"),
						rs2.getString("description"), rs2.getString("email"), rs2.getString("authorityName"),
						rs2.getString("authorityPhone"), rs2.getString("authorityEmail"),
						new Address(rs2.getString("Cstreet"), rs2.getString("Csuite"), rs2.getString("Ccity"),
								rs2.getString("CpostalCode"), rs2.getString("Ccountry")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}

}
