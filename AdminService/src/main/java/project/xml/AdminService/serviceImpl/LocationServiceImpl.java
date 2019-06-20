package project.xml.AdminService.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.xml.AdminService.model.Location;
import project.xml.AdminService.repository.LocationRepository;
import project.xml.AdminService.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService {
	
	@Autowired
	private LocationRepository locationRepository;

	@Override
	public Location saveLocation(Location location) {
		// TODO Auto-generated method stub
		return locationRepository.save(location);
	}

}
