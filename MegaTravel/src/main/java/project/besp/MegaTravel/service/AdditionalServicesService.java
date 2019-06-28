package project.besp.MegaTravel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import project.besp.MegaTravel.modelxsd.AdditionalServices;


@Service
public interface AdditionalServicesService{
	
	public AdditionalServices save(AdditionalServices additionalService);
	public List<AdditionalServices> getServices();
	public AdditionalServices getByName(String name);
	public AdditionalServices getById(Long id);

}
