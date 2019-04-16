package project.besp.MegaTravel.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.besp.MegaTravel.model.Role;
import project.besp.MegaTravel.repository.RoleRepository;
import project.besp.MegaTravel.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleRepository roleRepository;
	
	
	@Override
	public Role findByName(String name) {
		// TODO Auto-generated method stub
		return roleRepository.findByName(name);
	}
}
