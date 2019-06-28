package project.xml.AgentMegaTravel.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "User", propOrder = {
    "id",
    "firstName",
    "lastName",
    "email",
    "password",
    "pib",
    "certificated",
    "active",
    "blocked",
    "roles",
    "lastPasswordResetDate",
    "address",
    "reservations",
    "accommodations",
    "accommodation_units",
    "comments"
    
    
})
@Entity
@Table(name="user")
public class User   implements UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "user_id", nullable = false, updatable = false)
	public Long id;
	
	/*@Column(name = "role")
	@Enumerated(EnumType.STRING)
	public UserRole role;*/
	@Column(name = "first_name", nullable = false)
	public String firstName;
    
	
	@Column(name = "last_name", nullable = false)
	public String lastName;
	
	@Email
	@Column(name = "email", nullable = false)
	public String email; //username
    @Column(name = "password")
	public String password;
    @Column(name = "pib")
	public String pib;
    @Column(name = "certificated")
	private boolean certificated;
	//@JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable( 
        name = "user_roles", 
        joinColumns =  @JoinColumn(
          name = "user_id", referencedColumnName = "user_id"), 
        inverseJoinColumns = @JoinColumn(
        	name = "role_id", referencedColumnName = "id")) 
    private Collection<Role> roles;
	@JsonIgnore
	@Column(name = "last_password_reset_date")
	    private Date lastPasswordResetDate;
	 
	/*
	 * Vise korisnika (admin,agent,client) mogu biti na jednoj adresi
	 */
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "user_address")
	protected Address address;
	
	/*
	 * Samo client ima listu rezervacija (za sada) ili admin
	 */
	@JsonIgnore
	@OneToMany(mappedBy="user")
	protected List<Reservation> reservations;
	
	/*
	 * Samo admin ima listu smjestaja
	 */
	@JsonIgnore
	@OneToMany(mappedBy="user")
	protected List<Accommodation> accommodations;
	
	/*
	 * Samo agenti imaju listu smjestajnih jedinica
	 */
	@JsonIgnore
	@OneToMany(mappedBy="user")
	protected List<AccommodationUnit> accommodation_units;
	
	/*
	 * Admin i klijent upravljaju komentarima.
	 * Klijent moze da postavlja vise komentara.
	 */
	@JsonIgnore
	@OneToMany(mappedBy="user")
	protected List<Comment> comments;
	
	@Column(name = "active")
	private boolean active;
    
    @Column(name = "blocked")
	private boolean blocked;
	
	public User() {
		
	}
	
	public User( String firstName, String lastName, String email, String password,List<Role> roles) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.roles = roles;
	}

	@Override
	@Transient
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		if(!this.roles.isEmpty()) {
			Role r = roles.iterator().next();
			List<Privilege> privileges = new ArrayList<Privilege>();
			for(Privilege p : r.getPrivileges()) {
				privileges.add(p);
			}
			
			return privileges;
		}
		
		return null;
	}


	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.email;
	}
	
	public Long getId() {
		return id;
	}

	public void setUserId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	public void addRole(Role role) {
		this.roles.add(role);
	}

	public Date getLastPasswordResetDate() {
		return lastPasswordResetDate;
	}
	
	public void setLastPasswordResetDate(Date lastPasswordResetDate) {
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

	public boolean isCertificated() {
		return certificated;
	}

	public void setCertificated(boolean certificated) {
		this.certificated = certificated;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPib() {
		return pib;
	}

	public void setPib(String pib) {
		this.pib = pib;
	}

	public List<Accommodation> getAccommodations() {
		return accommodations;
	}

	public void setAccommodations(List<Accommodation> accommodations) {
		this.accommodations = accommodations;
	}

	public List<AccommodationUnit> getAccommodation_units() {
		return accommodation_units;
	}

	public void setAccommodation_units(List<AccommodationUnit> accommodation_units) {
		this.accommodation_units = accommodation_units;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}
	
	
	
}