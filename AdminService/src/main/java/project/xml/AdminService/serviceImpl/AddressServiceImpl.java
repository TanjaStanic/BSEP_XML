package project.xml.AdminService.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.xml.AdminService.model.Address;
import project.xml.AdminService.repository.AddressRepository;
import project.xml.AdminService.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	AddressRepository addressRepository;

	@Override
	public Address findOneById(Long id) {
		// TODO Auto-generated method stub
		return addressRepository.findOneById(id);
	}

}
