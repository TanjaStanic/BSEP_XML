package project.besp.MegaTravel.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import project.besp.MegaTravel.modelxsd.AdditionalServices;
import project.besp.MegaTravel.repository.AdditionalServicesRepository;
import project.besp.MegaTravel.service.AdditionalServicesService;

@Service
public class AdditionalServicesServiceImpl implements AdditionalServicesService {
	
	@Autowired
	private AdditionalServicesRepository additionalServiceRepository;

	@Override
	public AdditionalServices save(AdditionalServices additionalService) {
		// TODO Auto-generated method stub
		return additionalServiceRepository.save(additionalService);
	}

	@Override
	public List<AdditionalServices> getServices() {
		// TODO Auto-generated method stub
		return additionalServiceRepository.findAll();
	}

	@Override
	public AdditionalServices getByName(String name) {
		// TODO Auto-generated method stub
		return additionalServiceRepository.findByName(name);
	}

	@Override
	public AdditionalServices getById(Long id) {
		// TODO Auto-generated method stub
		return additionalServiceRepository.findById(id).get();
	}

}
