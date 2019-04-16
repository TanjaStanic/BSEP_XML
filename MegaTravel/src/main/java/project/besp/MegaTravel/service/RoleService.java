package project.besp.MegaTravel.service;

import org.springframework.stereotype.Service;

import project.besp.MegaTravel.model.Role;

@Service

public interface RoleService {
	Role findByName(String name);

}
