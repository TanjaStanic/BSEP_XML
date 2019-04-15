package project.besp.MegaTravel.model;

import java.io.Serializable;
import java.security.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
@Table(name = "user")
public class User implements UserDetails, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "user_id", nullable = false, updatable = false)
	public Long id;
	
	/*@Column(name = "role")
	@Enumerated(EnumType.STRING)
	public UserRole role;*/
	
	@Column(name = "first_name")
	public String firstName;
    
	

	@Column(name = "last_name")
	public String lastName;
	
	@Column(name = "email")
	public String email; //username
	
    @Column(name = "password")
	public String password;
    
    @Column(name = "certificated")
	private boolean certificated;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	 @JoinTable( 
	        name = "user_authority", 
		            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
		            inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id")) 
	 @JsonIgnore
	    private List<Authority> authorities;
	
	 @Column(name = "last_password_reset_date")
	    private Date lastPasswordResetDate;

	public UserRole roles;
	
	public User() {
		
	}
	
	public User( String firstName, String lastName, String email, String password,List<Authority> authorities) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return this.authorities;
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

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
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
	
	


	
}
