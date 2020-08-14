package ca.codeboxx;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import ca.codeboxx.model.Battery;
import ca.codeboxx.model.Column;
import ca.codeboxx.model.Elevator;
import ca.codeboxx.model.Intervention;

public class Mutation implements GraphQLRootResolver {
	
	public Mutation() {
		
	}
	
	public Intervention updateIntervention(int id, String status) {
		Database d = new Database("jdbc:mysql://localhost:3306/rocket-foundation","root","Alexandre07!", "jdbc:postgresql://codeboxx-postgresql.cq6zrczewpu2.us-east-1.rds.amazonaws.com/ThierryHarvey", "codeboxx", "Codeboxx1!");
		return d.updateIntervention(id, status);
	}
	public Elevator updateElevator(int id, String status) {
		Database d = new Database("jdbc:mysql://codeboxx.cq6zrczewpu2.us-east-1.rds.amazonaws.com/ThierryHarvey","codeboxx","Codeboxx1!", "jdbc:postgresql://codeboxx-postgresql.cq6zrczewpu2.us-east-1.rds.amazonaws.com/ThierryHarvey", "codeboxx", "Codeboxx1!");
    	return d.updateElevator(id, status);
	}
	public Column updateColumn(int id, String status) {
		Database d = new Database("jdbc:mysql://codeboxx.cq6zrczewpu2.us-east-1.rds.amazonaws.com/ThierryHarvey","codeboxx","Codeboxx1!", "jdbc:postgresql://codeboxx-postgresql.cq6zrczewpu2.us-east-1.rds.amazonaws.com/ThierryHarvey", "codeboxx", "Codeboxx1!");
    	return d.updateColumn(id, status);
	}
	public Battery updateBattery(int id, String status) {
		Database d = new Database("jdbc:mysql://codeboxx.cq6zrczewpu2.us-east-1.rds.amazonaws.com/ThierryHarvey","codeboxx","Codeboxx1!", "jdbc:postgresql://codeboxx-postgresql.cq6zrczewpu2.us-east-1.rds.amazonaws.com/ThierryHarvey", "codeboxx", "Codeboxx1!");
    	return d.updateBattery(id, status);
	}

}
