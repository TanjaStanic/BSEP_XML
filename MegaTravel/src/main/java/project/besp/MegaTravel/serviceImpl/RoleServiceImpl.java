package project.besp.MegaTravel.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.besp.MegaTravel.model.Authority;
import project.besp.MegaTravel.model.Role;
import project.besp.MegaTravel.repository.RoleRepository;
import project.besp.MegaTravel.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleRepository roleRepository;
	
	
	@Override
	public Role findByName(Authority name) {
		// TODO Auto-generated method stub
		return roleRepository.findByName(name);
	}


	@Override
	public Role findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Role findById(int id) {
		// TODO Auto-generated method stub
		return roleRepository.findById(id);
	}
	
}
