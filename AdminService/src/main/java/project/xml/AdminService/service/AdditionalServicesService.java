package project.xml.AdminService.service;

import java.util.List;

import org.springframework.stereotype.Service;

import project.xml.AdminService.model.AdditionalServices;

@Service
public interface AdditionalServicesService {
	List<AdditionalServices> getAll();
}
