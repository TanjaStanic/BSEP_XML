package project.xml.AdminService.service;

import org.springframework.stereotype.Service;

import project.xml.AdminService.model.Location;


@Service
public interface LocationService {
	Location saveLocation(Location location);
}
