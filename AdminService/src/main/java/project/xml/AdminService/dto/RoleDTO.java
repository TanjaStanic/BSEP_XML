package project.xml.AdminService.dto;

import project.xml.AdminService.model.Role;
import project.xml.AdminService.model.RoleName;

public class RoleDTO {
	private Long id;
	private RoleName name;
	private String name1;
	
	public RoleDTO(RoleName name) {
		this.name = name;
	}
	
	public RoleDTO(String name1) {
		this.name1 = name1;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RoleName getName() {
		return name;
	}

	public void setName(RoleName name) {
		this.name = name;
	}
	
	

}
