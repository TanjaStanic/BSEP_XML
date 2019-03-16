package project.besp.MegaTravel.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.besp.MegaTravel.data.WithDrawCert;
import project.besp.MegaTravel.repository.WithDrawCertRepository;
import project.besp.MegaTravel.service.WithDrawCertService;

@Service
public class WithDrawServiceImpl implements WithDrawCertService{

	@Autowired
	WithDrawCertRepository wdcr;
	
	@Override
	public WithDrawCert save(WithDrawCert w) {
		return wdcr.save(w);
	}

	@Override
	public WithDrawCert findbySerial(String serialNumber) {
		return wdcr.findBySerialNumber(serialNumber);

	}

}
