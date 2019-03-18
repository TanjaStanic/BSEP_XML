package project.besp.MegaTravel.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project.besp.MegaTravel.model.Role;
import project.besp.MegaTravel.repository.RoleRepository;
import project.besp.MegaTravel.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public Role findOne(Long id) {
		
		roleRepository.findById(id);
		return null;
	}

}
