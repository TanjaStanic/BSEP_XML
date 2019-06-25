package project.xml.AdminService.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.xml.AdminService.model.Authority;
import project.xml.AdminService.model.Role;
import project.xml.AdminService.repository.RoleRepository;
import project.xml.AdminService.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleRepository roleRepository;
	


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


	@Override
	public Role findByName(Authority name) {
		// TODO Auto-generated method stub
		return roleRepository.findByName(name);
	}
	
}
