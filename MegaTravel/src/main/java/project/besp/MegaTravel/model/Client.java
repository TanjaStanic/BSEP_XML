package project.besp.MegaTravel.model;

import javax.persistence.Entity;
import javax.validation.constraints.Size;

@Entity
public class Client extends User {

	@Size(max = 1)
	public String row;

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(String firstName, String lastName, String userName, String password, String row) {
		super(firstName, lastName, userName, password);
		this.row = row;
	}
	
	
}
