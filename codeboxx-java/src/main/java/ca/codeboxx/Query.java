package ca.codeboxx;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import ca.codeboxx.model.Battery;
import ca.codeboxx.model.Build;
import ca.codeboxx.model.Building;
import ca.codeboxx.model.Column;
import ca.codeboxx.model.Elevator;
import ca.codeboxx.model.Employee;
import ca.codeboxx.model.Intervention;
import ca.codeboxx.model.Lead;

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
    
    public List<Intervention> interventionList(){
    	Database d = new Database("jdbc:mysql://codeboxx.cq6zrczewpu2.us-east-1.rds.amazonaws.com/ThierryHarvey","codeboxx","Codeboxx1!", "jdbc:postgresql://codeboxx-postgresql.cq6zrczewpu2.us-east-1.rds.amazonaws.com/ThierryHarvey", "codeboxx", "Codeboxx1!");
    	return d.getInterventionList();
    }
    
    public Battery battery(int id) {
    	Database d = new Database("jdbc:mysql://codeboxx.cq6zrczewpu2.us-east-1.rds.amazonaws.com/ThierryHarvey","codeboxx","Codeboxx1!", "jdbc:postgresql://codeboxx-postgresql.cq6zrczewpu2.us-east-1.rds.amazonaws.com/ThierryHarvey", "codeboxx", "Codeboxx1!");
    	return d.getBattery(id);
    }
    
    public Column column(int id) {
    	Database d = new Database("jdbc:mysql://codeboxx.cq6zrczewpu2.us-east-1.rds.amazonaws.com/ThierryHarvey","codeboxx","Codeboxx1!", "jdbc:postgresql://codeboxx-postgresql.cq6zrczewpu2.us-east-1.rds.amazonaws.com/ThierryHarvey", "codeboxx", "Codeboxx1!");
    	return d.getColumn(id);
    }
    
    public List<Lead> leads(){
    	Database d = new Database("jdbc:mysql://codeboxx.cq6zrczewpu2.us-east-1.rds.amazonaws.com/ThierryHarvey","codeboxx","Codeboxx1!", "jdbc:postgresql://codeboxx-postgresql.cq6zrczewpu2.us-east-1.rds.amazonaws.com/ThierryHarvey", "codeboxx", "Codeboxx1!");
    	return d.getLead();
    }
    
    public List<Elevator> elevatorList(){
    	Database d = new Database("jdbc:mysql://codeboxx.cq6zrczewpu2.us-east-1.rds.amazonaws.com/ThierryHarvey","codeboxx","Codeboxx1!", "jdbc:postgresql://codeboxx-postgresql.cq6zrczewpu2.us-east-1.rds.amazonaws.com/ThierryHarvey", "codeboxx", "Codeboxx1!");
    	return d.getElevatorList();
    }
    
    public Elevator elevator(int id){
    	Database d = new Database("jdbc:mysql://codeboxx.cq6zrczewpu2.us-east-1.rds.amazonaws.com/ThierryHarvey","codeboxx","Codeboxx1!", "jdbc:postgresql://codeboxx-postgresql.cq6zrczewpu2.us-east-1.rds.amazonaws.com/ThierryHarvey", "codeboxx", "Codeboxx1!");
    	return d.getElevator(id);
    }
    
    public List<Build> buildList(){
    	Database d = new Database("jdbc:mysql://codeboxx.cq6zrczewpu2.us-east-1.rds.amazonaws.com/ThierryHarvey","codeboxx","Codeboxx1!", "jdbc:postgresql://codeboxx-postgresql.cq6zrczewpu2.us-east-1.rds.amazonaws.com/ThierryHarvey", "codeboxx", "Codeboxx1!");
    	return d.getBuildIntervention();
    }
    
}
