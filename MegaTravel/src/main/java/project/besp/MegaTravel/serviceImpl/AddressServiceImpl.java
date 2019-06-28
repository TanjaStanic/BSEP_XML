package project.besp.MegaTravel.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.besp.MegaTravel.modelxsd.Address;
import project.besp.MegaTravel.repository.AddressRepository;
import project.besp.MegaTravel.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	private AddressRepository addressRepository;

	@Override
	public Address getByStreetNumberCityState(String street, String number, String city, String state) {
		// TODO Auto-generated method stub
		return addressRepository.getByStreetNumberCityPTTState(street, number, city, state);
	}

	@Override
	public Address save(Address address) {
		// TODO Auto-generated method stub
		return addressRepository.save(address);
	}

	@Override
	public Address getById(Long i) {
		// TODO Auto-generated method stub
		return addressRepository.findById(i).get();
	}

	@Override
	public List<Address> getByCityName(String string) {
		// TODO Auto-generated method stub
		return addressRepository.getByCityName(string);
	}

}
