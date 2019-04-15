package project.besp.MegaTravel.service;

import org.springframework.stereotype.Service;

import project.besp.MegaTravel.model.Authority;


@Service
public interface AuthService {
	Authority findOneById(Long id);
	Authority findOneByName(String name);
	Authority saveAuthority(Authority a);
}
