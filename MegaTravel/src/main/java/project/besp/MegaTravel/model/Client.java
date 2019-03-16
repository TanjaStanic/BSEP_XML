package project.besp.MegaTravel.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client extends User {



	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(String firstName, String lastName, String userName, String password) {
		super(firstName, lastName, userName, password);
	}
	
	
}
