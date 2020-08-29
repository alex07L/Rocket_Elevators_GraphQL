package ca.codeboxx;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import ca.codeboxx.model.Address;
import ca.codeboxx.model.Battery;
import ca.codeboxx.model.Column;
import ca.codeboxx.model.Customer;
import ca.codeboxx.model.Elevator;
import ca.codeboxx.model.Intervention;

public class Mutation implements GraphQLRootResolver {
	
	public Mutation() {
		
	}
	
	public Intervention updateIntervention(int id, String status) {
		Database d = new Database("jdbc:mysql://codeboxx.cq6zrczewpu2.us-east-1.rds.amazonaws.com/AlexandreLevesque","codeboxx","Codeboxx1!", "jdbc:postgresql://codeboxx-postgresql.cq6zrczewpu2.us-east-1.rds.amazonaws.com/AlexandreLevesque", "codeboxx", "Codeboxx1!");
		return d.updateIntervention(id, status);
	}
	public Elevator updateElevator(int id, String status) {
		Database d = new Database("jdbc:mysql://codeboxx.cq6zrczewpu2.us-east-1.rds.amazonaws.com/AlexandreLevesque","codeboxx","Codeboxx1!", "jdbc:postgresql://codeboxx-postgresql.cq6zrczewpu2.us-east-1.rds.amazonaws.com/AlexandreLevesque", "codeboxx", "Codeboxx1!");
    	return d.updateElevator(id, status);
	}
	public Column updateColumn(int id, String status) {
		Database d = new Database("jdbc:mysql://codeboxx.cq6zrczewpu2.us-east-1.rds.amazonaws.com/AlexandreLevesque","codeboxx","Codeboxx1!", "jdbc:postgresql://codeboxx-postgresql.cq6zrczewpu2.us-east-1.rds.amazonaws.com/AlexandreLevesque", "codeboxx", "Codeboxx1!");
    	return d.updateColumn(id, status);
	}
	public Battery updateBattery(int id, String status) {
		Database d = new Database("jdbc:mysql://codeboxx.cq6zrczewpu2.us-east-1.rds.amazonaws.com/AlexandreLevesque","codeboxx","Codeboxx1!", "jdbc:postgresql://codeboxx-postgresql.cq6zrczewpu2.us-east-1.rds.amazonaws.com/AlexandreLevesque", "codeboxx", "Codeboxx1!");
    	return d.updateBattery(id, status);
	}
	
	public Intervention addIntevention(String customer, int build, int battery, int column, int elevator, String description) {
		Database d = new Database("jdbc:mysql://codeboxx.cq6zrczewpu2.us-east-1.rds.amazonaws.com/AlexandreLevesque","codeboxx","Codeboxx1!", "jdbc:postgresql://codeboxx-postgresql.cq6zrczewpu2.us-east-1.rds.amazonaws.com/AlexandreLevesque", "codeboxx", "Codeboxx1!");
		return d.addIntervention(customer, build, battery, column, elevator, description);
	}
	
	public Address UpdateAddress(int id, String street, String suite, String city, String postalCode, String country) {
		Database d = new Database("jdbc:mysql://codeboxx.cq6zrczewpu2.us-east-1.rds.amazonaws.com/AlexandreLevesque","codeboxx","Codeboxx1!", "jdbc:postgresql://codeboxx-postgresql.cq6zrczewpu2.us-east-1.rds.amazonaws.com/AlexandreLevesque", "codeboxx", "Codeboxx1!");
		return d.updateAddress(id, street, city, country, postalCode, suite);
	}
	
	public Customer updateEmail(String email, String newEmail) {
		Database d = new Database("jdbc:mysql://codeboxx.cq6zrczewpu2.us-east-1.rds.amazonaws.com/AlexandreLevesque","codeboxx","Codeboxx1!", "jdbc:postgresql://codeboxx-postgresql.cq6zrczewpu2.us-east-1.rds.amazonaws.com/AlexandreLevesque", "codeboxx", "Codeboxx1!");
		return d.updateEmail(email, newEmail);
	}

}
