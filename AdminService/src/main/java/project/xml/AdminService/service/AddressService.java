package project.xml.AdminService.service;

import org.springframework.stereotype.Service;

import project.xml.AdminService.model.Address;

@Service
public interface AddressService {
	Address findOneById(Long id);

}
