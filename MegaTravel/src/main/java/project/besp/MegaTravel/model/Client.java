package project.besp.MegaTravel.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "client")
public class Client extends User {

	@Size(max = 1)
	public String type;

	

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(String firstName, String lastName, String userName, String password, String type ) {
		super(firstName, lastName, userName, password);
		this.type = type;
	}
	
	
}
