package ca.codeboxx;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import ca.codeboxx.model.Building;
import ca.codeboxx.model.Employee;
import ca.codeboxx.model.Intervention;

public class Query implements GraphQLRootResolver {

    public Query() {
    }
    
    public Intervention intervention(int id) {
    	Database d = new Database("jdbc:mysql://codeboxx.cq6zrczewpu2.us-east-1.rds.amazonaws.com/ThierryHarvey","codeboxx","Codeboxx1!", "jdbc:postgresql://codeboxx-postgresql.cq6zrczewpu2.us-east-1.rds.amazonaws.com/ThierryHarvey", "codeboxx", "Codeboxx1!");
    	return d.getIntervention(id);
    }
    
    public Building buildings(int id) {
    	Database d = new Database("jdbc:mysql://codeboxx.cq6zrczewpu2.us-east-1.rds.amazonaws.com/ThierryHarvey","codeboxx","Codeboxx1!", "jdbc:postgresql://codeboxx-postgresql.cq6zrczewpu2.us-east-1.rds.amazonaws.com/ThierryHarvey", "codeboxx", "Codeboxx1!");
    	return d.getBuilding(id);
    }
    public Employee employee(int id) {
    	Database d = new Database("jdbc:mysql://codeboxx.cq6zrczewpu2.us-east-1.rds.amazonaws.com/ThierryHarvey","codeboxx","Codeboxx1!", "jdbc:postgresql://codeboxx-postgresql.cq6zrczewpu2.us-east-1.rds.amazonaws.com/ThierryHarvey", "codeboxx", "Codeboxx1!");
    	return d.getEmployee(id);
    }
}
