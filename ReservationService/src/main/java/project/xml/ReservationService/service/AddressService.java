package project.xml.ReservationService.service;

import java.util.List;

import project.xml.ReservationService.model.Address;

public interface AddressService {
	
	List<Address> getAllAdresses();
	Address getOne(Long id);

}
