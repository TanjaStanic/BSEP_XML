package project.besp.MegaTravel.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class User {
	
	@Id
	@GeneratedValue
	public Long id;
	
	@Enumerated(EnumType.STRING)
	public UserRole role;
	
	public String firstName;
	public String lastName;
	public String userName;
	public String password;
	
	@ManyToMany(fetch = FetchType.EAGER)
	 @JoinTable( 
	        name = "user_roles", 
	        joinColumns = @JoinColumn(
	        		name = "user_id", referencedColumnName = "id"), 
	        inverseJoinColumns = @JoinColumn(
	        		name = "role_id", referencedColumnName = "id")) 
	 @JsonIgnore
	    public Collection<Role> roles;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User( String firstName, String lastName, String userName, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
	}

	
}
