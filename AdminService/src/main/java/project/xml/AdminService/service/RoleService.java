package project.xml.AdminService.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import project.xml.AdminService.model.Authority;
import project.xml.AdminService.model.Role;

@Service

public interface RoleService {
	//Role findByName(String name);

	Role findByName(Authority name);

	Role findByName(String name);

	Role findById(int id);

}
