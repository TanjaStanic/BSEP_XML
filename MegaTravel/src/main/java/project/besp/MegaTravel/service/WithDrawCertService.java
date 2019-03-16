package project.besp.MegaTravel.service;

import org.springframework.stereotype.Service;
import project.besp.MegaTravel.data.WithDrawCert;

@Service
public interface WithDrawCertService {

	WithDrawCert save(WithDrawCert w);
	
	WithDrawCert findbySerial(String serialNumber);
}
