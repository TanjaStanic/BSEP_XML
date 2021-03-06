package project.besp.MegaTravel.serviceImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
		
		return ccrsr.save(c);
	}

	
	
}
