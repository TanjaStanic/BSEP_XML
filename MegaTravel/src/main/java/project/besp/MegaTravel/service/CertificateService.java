package project.besp.MegaTravel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import project.besp.MegaTravel.model.Certificate;

@Service
public interface CertificateService {
	Certificate findOneById(Long id);
	Certificate saveCertificate(Certificate certificate);
	void removeCertificate(Long id);
	Certificate findOneByIdSubject(Long id);
	Certificate findOneByIdIssuer(Long id);
	List<Certificate> getAll();

}
