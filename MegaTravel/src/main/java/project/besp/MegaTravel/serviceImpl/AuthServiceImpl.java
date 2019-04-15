package project.besp.MegaTravel.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.besp.MegaTravel.model.Authority;
import project.besp.MegaTravel.repository.AuthRepository;
import project.besp.MegaTravel.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {
	
	@Autowired
	AuthRepository repository;

	@Override
	public Authority findOneById(Long id) {
		// TODO Auto-generated method stub
		return repository.findOneById(id);
	}

	@Override
	public Authority findOneByName(String name) {
		// TODO Auto-generated method stub
		return repository.findOneByName(name);
	}

	@Override
	public Authority saveAuthority(Authority a) {
		// TODO Auto-generated method stub
		return repository.save(a);
	}

}
