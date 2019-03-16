package project.besp.MegaTravel.service;

import org.springframework.stereotype.Service;

import project.besp.MegaTravel.data.CertificateCSR;

@Service
public interface CertificateCSRService {
	CertificateCSR save(CertificateCSR c);

}
