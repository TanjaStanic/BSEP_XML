package project.besp.MegaTravel.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "user")
@Inheritance(strategy=InheritanceType.JOINED)
public class User implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false, updatable = false)
	public Long id;
	
	@Column(name = "role")
	@Enumerated(EnumType.STRING)
	public UserRole role;
	
	@Column(name = "first_name")
	public String firstName;
    
	@Column(name = "last_name")
	public String lastName;
	
	@Column(name = "user_name")
	public String userName;
	
    @Column(name = "password")
	public String password;
	
	@ManyToMany(fetch = FetchType.EAGER)
	 @JoinTable( 
	        name = "user_roles", 
	        joinColumns = @JoinColumn(
	        		name = "user_id", referencedColumnName = "user_id"), 
	        inverseJoinColumns = @JoinColumn(
	        		name = "role_id", referencedColumnName = "role_id")) 
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
