package project.besp.MegaTravel.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name = "privilege")
public class Privilege {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "privilege_id", nullable = false, updatable = false)
    public Long id;
 
    @Column(name = "privilege_name")
    public String name;
 
    @ManyToMany(mappedBy = "privileges")
    private Collection<Role> roles;

	public Privilege(String name) {
		super();
		this.name = name;
	}

	public Privilege() {
		super();
	}
}
