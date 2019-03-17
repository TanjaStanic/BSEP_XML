package project.besp.MegaTravel.serviceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project.besp.MegaTravel.model.Client;
import project.besp.MegaTravel.model.Role;
import project.besp.MegaTravel.model.UserRole;
import project.besp.MegaTravel.repository.ClientRepository;
import project.besp.MegaTravel.service.ClientService;
import project.besp.MegaTravel.service.RoleService;

@Service
@Transactional
public class ClientServiceImpl implements ClientService{
	
	@Autowired
	ClientRepository userRepository;
	
	@Autowired
	RoleService roleServis;

	@Override
	public Client registracijaKlijenta(Client k) {
		// TODO Auto-generated method stub
	    k.type = "P";
		k.role = UserRole.Client;
		k.roles = new ArrayList<Role>();
		k.roles.add(roleServis.findOne(Long.valueOf(1)));
		return userRepository.save(k);
	}

	@Override
	public Client registracijaKlijentaF(Client k) {
		// TODO Auto-generated method stub
		k.type = "F";
		k.role = UserRole.Client;
		k.roles = new ArrayList<Role>();
		k.roles.add(roleServis.findOne(Long.valueOf(1)));
		return userRepository.save(k);
	}

	@Override
	public Client preuzmiKlijenta(Long id) {
		return userRepository.findOne(id);
	}

}
