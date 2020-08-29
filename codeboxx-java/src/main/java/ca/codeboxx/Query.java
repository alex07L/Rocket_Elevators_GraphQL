package ca.codeboxx;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import ca.codeboxx.model.Address;
import ca.codeboxx.model.Battery;
import ca.codeboxx.model.Build;
import ca.codeboxx.model.Building;
import ca.codeboxx.model.Column;
import ca.codeboxx.model.Customer;
import ca.codeboxx.model.Cx;
import ca.codeboxx.model.Elevator;
import ca.codeboxx.model.Employee;
import ca.codeboxx.model.Intervention;
import ca.codeboxx.model.Lead;

public class Query implements GraphQLRootResolver {

    public Query() {
    }
    
    public Intervention intervention(int id) {
    	Database d = new Database("jdbc:mysql://codeboxx.cq6zrczewpu2.us-east-1.rds.amazonaws.com/AlexandreLevesque","codeboxx","Codeboxx1!", "jdbc:postgresql://codeboxx-postgresql.cq6zrczewpu2.us-east-1.rds.amazonaws.com/AlexandreLevesque", "codeboxx", "Codeboxx1!");
    	return d.getIntervention(id);
    }
    
    public Building buildings(int id) {
    	Database d = new Database("jdbc:mysql://codeboxx.cq6zrczewpu2.us-east-1.rds.amazonaws.com/AlexandreLevesque","codeboxx","Codeboxx1!", "jdbc:postgresql://codeboxx-postgresql.cq6zrczewpu2.us-east-1.rds.amazonaws.com/AlexandreLevesque", "codeboxx", "Codeboxx1!");
    	return d.getBuilding(id);
    }
    public Employee employee(int id) {
    	Database d = new Database("jdbc:mysql://codeboxx.cq6zrczewpu2.us-east-1.rds.amazonaws.com/AlexandreLevesque","codeboxx","Codeboxx1!", "jdbc:postgresql://codeboxx-postgresql.cq6zrczewpu2.us-east-1.rds.amazonaws.com/AlexandreLevesque", "codeboxx", "Codeboxx1!");
    	return d.getEmployee(id);
    }
    
    public List<Intervention> interventionList(){
    	Database d = new Database("jdbc:mysql://codeboxx.cq6zrczewpu2.us-east-1.rds.amazonaws.com/AlexandreLevesque","codeboxx","Codeboxx1!", "jdbc:postgresql://codeboxx-postgresql.cq6zrczewpu2.us-east-1.rds.amazonaws.com/AlexandreLevesque", "codeboxx", "Codeboxx1!");
    	return d.getInterventionList();
    }
    
    public Battery battery(int id) {
    	Database d = new Database("jdbc:mysql://codeboxx.cq6zrczewpu2.us-east-1.rds.amazonaws.com/AlexandreLevesque","codeboxx","Codeboxx1!", "jdbc:postgresql://codeboxx-postgresql.cq6zrczewpu2.us-east-1.rds.amazonaws.com/AlexandreLevesque", "codeboxx", "Codeboxx1!");
    	return d.getBattery(id);
    }
    
    public Column column(int id) {
    	Database d = new Database("jdbc:mysql://codeboxx.cq6zrczewpu2.us-east-1.rds.amazonaws.com/AlexandreLevesque","codeboxx","Codeboxx1!", "jdbc:postgresql://codeboxx-postgresql.cq6zrczewpu2.us-east-1.rds.amazonaws.com/AlexandreLevesque", "codeboxx", "Codeboxx1!");
    	return d.getColumn(id);
    }
    
    public List<Lead> leads(){
    	Database d = new Database("jdbc:mysql://codeboxx.cq6zrczewpu2.us-east-1.rds.amazonaws.com/AlexandreLevesque","codeboxx","Codeboxx1!", "jdbc:postgresql://codeboxx-postgresql.cq6zrczewpu2.us-east-1.rds.amazonaws.com/AlexandreLevesque", "codeboxx", "Codeboxx1!");
    	return d.getLead();
    }
    
    public List<Elevator> elevatorList(){
    	Database d = new Database("jdbc:mysql://codeboxx.cq6zrczewpu2.us-east-1.rds.amazonaws.com/AlexandreLevesque","codeboxx","Codeboxx1!", "jdbc:postgresql://codeboxx-postgresql.cq6zrczewpu2.us-east-1.rds.amazonaws.com/AlexandreLevesque", "codeboxx", "Codeboxx1!");
    	return d.getElevatorList();
    }
    
    public Elevator elevator(int id){
    	Database d = new Database("jdbc:mysql://codeboxx.cq6zrczewpu2.us-east-1.rds.amazonaws.com/AlexandreLevesque","codeboxx","Codeboxx1!", "jdbc:postgresql://codeboxx-postgresql.cq6zrczewpu2.us-east-1.rds.amazonaws.com/AlexandreLevesque", "codeboxx", "Codeboxx1!");
    	return d.getElevator(id);
    }
    
    public List<Build> buildList(){
    	Database d = new Database("jdbc:mysql://codeboxx.cq6zrczewpu2.us-east-1.rds.amazonaws.com/AlexandreLevesque","codeboxx","Codeboxx1!", "jdbc:postgresql://codeboxx-postgresql.cq6zrczewpu2.us-east-1.rds.amazonaws.com/AlexandreLevesque", "codeboxx", "Codeboxx1!");
    	return d.getBuildIntervention();
    }
    
    public Customer customer(String email) {
    	Database d = new Database("jdbc:mysql://codeboxx.cq6zrczewpu2.us-east-1.rds.amazonaws.com/AlexandreLevesque","codeboxx","Codeboxx1!", "jdbc:postgresql://codeboxx-postgresql.cq6zrczewpu2.us-east-1.rds.amazonaws.com/AlexandreLevesque", "codeboxx", "Codeboxx1!");
    	return d.getCustomer(email);
    }
    
    public Cx cxbyCustomer(String email) {
    	Database d = new Database("jdbc:mysql://codeboxx.cq6zrczewpu2.us-east-1.rds.amazonaws.com/AlexandreLevesque","codeboxx","Codeboxx1!", "jdbc:postgresql://codeboxx-postgresql.cq6zrczewpu2.us-east-1.rds.amazonaws.com/AlexandreLevesque", "codeboxx", "Codeboxx1!");
    	return d.cxbyCustomer(email);
    }
    
    public List<Address> addressbyCustomer(String email){
    	Database d = new Database("jdbc:mysql://codeboxx.cq6zrczewpu2.us-east-1.rds.amazonaws.com/AlexandreLevesque","codeboxx","Codeboxx1!", "jdbc:postgresql://codeboxx-postgresql.cq6zrczewpu2.us-east-1.rds.amazonaws.com/AlexandreLevesque", "codeboxx", "Codeboxx1!");
    	return d.getAddresses(email);
    }
    
    public Address address(int id) {
    	Database d = new Database("jdbc:mysql://codeboxx.cq6zrczewpu2.us-east-1.rds.amazonaws.com/AlexandreLevesque","codeboxx","Codeboxx1!", "jdbc:postgresql://codeboxx-postgresql.cq6zrczewpu2.us-east-1.rds.amazonaws.com/AlexandreLevesque", "codeboxx", "Codeboxx1!");
    	return d.getAddresses(id);
    }
    
}
