package project.besp.MegaTravel.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project.besp.MegaTravel.data.CertificateCSR;
import project.besp.MegaTravel.repository.CertificateCSRRepository;
import project.besp.MegaTravel.service.CertificateCSRService;

@Service
@Transactional
public class CertificateCSRServiceImpl implements CertificateCSRService {
	
	@Autowired
	CertificateCSRRepository ccrsr;
	
	@Override
	public CertificateCSR save(CertificateCSR c) {
		// TODO Auto-generated method stub
		return ccrsr.save(c);
	}

}
