package project.xml.AdminService.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.xml.AdminService.model.AdditionalServices;
import project.xml.AdminService.repository.AdditionalServiceRepository;
import project.xml.AdminService.service.AdditionalServicesService;

@Service
public class AdditionalServicesServiceImpl implements AdditionalServicesService {
	
	@Autowired	
	AdditionalServiceRepository aditionalRepository;

	@Override
	public List<AdditionalServices> getAll() {
		// TODO Auto-generated method stub
		return aditionalRepository.findAll();
	}

}
