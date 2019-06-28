package project.besp.MegaTravel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import project.besp.MegaTravel.modelxsd.Address;

@Service
public interface AddressService {
	
	Address getByStreetNumberCityState(String street, String number,
			String city, String state);

	Address save(Address address);

	Address getById(Long i);

	List<Address> getByCityName(String string);

}
