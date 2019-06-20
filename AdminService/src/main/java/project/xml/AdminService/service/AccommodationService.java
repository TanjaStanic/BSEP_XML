package project.xml.AdminService.service;

import java.util.List;

import org.springframework.stereotype.Service;

import project.xml.AdminService.model.Accommodation;
import project.xml.AdminService.model.Location;

@Service
public interface AccommodationService {
	List<Accommodation> getAll();
	

}
