package project.xml.AdminService.dto;

import java.util.ArrayList;
import java.util.List;

import project.xml.AdminService.model.Role;
import project.xml.AdminService.model.User;


public class UserDTO {
	
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String pib;
	private boolean certificated;
	private boolean active;
	private boolean blocked;
	private List<RoleDTO> roles;
	
	
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public UserDTO(Long id, String firstName, String lastName, String email, String password, String pib,
			boolean certificated, boolean active, boolean blocked, List<RoleDTO> roles) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.pib = pib;
		this.certificated = certificated;
		this.active = active;
		this.blocked = blocked;
		this.roles = roles;
	}
	
	public UserDTO(User u) {
		this.id = u.getId();
		this.firstName = u.getFirstName();
		this.lastName = u.getLastName();
		this.email = u.getEmail();
		this.password = u.getPassword();
		this.active = u.isActive();
		this.blocked = u.isBlocked();
		
		roles = new ArrayList<>();
		if(u.getRoles() != null) {
			for(Role r : u.getRoles()) {
				roles.add(new RoleDTO(r.getName()));
			}
		}
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
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


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getPib() {
		return pib;
	}


	public void setPib(String pib) {
		this.pib = pib;
	}


	public boolean isCertificated() {
		return certificated;
	}


	public void setCertificated(boolean certificated) {
		this.certificated = certificated;
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


	public List<RoleDTO> getRoles() {
		return roles;
	}


	public void setRoles(List<RoleDTO> roles) {
		this.roles = roles;
	}
	
	
	
	
	


}
