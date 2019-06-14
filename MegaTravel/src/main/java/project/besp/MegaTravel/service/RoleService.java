package project.besp.MegaTravel.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import project.besp.MegaTravel.model.Authority;
import project.besp.MegaTravel.model.Role;

@Service

public interface RoleService {
	//Role findByName(String name);

	Role findByName(Authority name);

	Role findByName(String name);

	Role findById(int id);

}
