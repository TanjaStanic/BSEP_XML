package project.besp.MegaTravel.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Employee extends User {
	
	@Enumerated(EnumType.STRING)
	public EmployeeRole employeeRole;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String firstName, String lastName, String userName, String password, EmployeeRole employeeRole) {
		super(firstName, lastName, userName, password);
		this.employeeRole = employeeRole;
	}
	
	
}
