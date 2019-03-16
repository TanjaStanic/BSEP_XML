package project.besp.MegaTravel.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "role")
public class Role {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id", nullable = false, updatable = false)
    public Long id;
	
    @Column(name = "role_name", nullable = false)
	public String name;
    
    @ManyToMany(mappedBy = "roles")
    @JsonIgnore
    private Collection<User> users;
 
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "Roles_privileges", 
        joinColumns = @JoinColumn(
          name = "role_id", referencedColumnName = "role_id"), 
        inverseJoinColumns = @JoinColumn(
          name = "privilege_id", referencedColumnName = "privilege_id"))
    public Collection<Privilege> privileges;

	public Role(String name) {
		super();
		this.name = name;
	}

	public Role() {
		super();
	}  
}
