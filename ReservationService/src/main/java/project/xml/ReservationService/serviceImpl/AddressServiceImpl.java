package project.xml.ReservationService.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.xml.ReservationService.model.Address;
import project.xml.ReservationService.repository.AddressRepository;
import project.xml.ReservationService.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	AddressRepository addressRepository;

	@Override
	public List<Address> getAllAdresses() {
		return addressRepository.findAll();
	}

	@Override
	public Address getOne(Long id) {
		return addressRepository.getOne(id);
	}

}
