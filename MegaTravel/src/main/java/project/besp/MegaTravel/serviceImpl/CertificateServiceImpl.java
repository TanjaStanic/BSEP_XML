package project.besp.MegaTravel.serviceImpl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.besp.MegaTravel.model.Certificate;
import project.besp.MegaTravel.repository.CertificateRepository;
import project.besp.MegaTravel.service.CertificateService;


@Service
public class CertificateServiceImpl implements CertificateService {
	

	@Autowired
	CertificateRepository certificateRepository;
	
	
	@Override
	public List<Certificate> getAll() {
		
		return certificateRepository.findAll();
	}


	@Override
	public Certificate findOneById(Long id) {
		// TODO Auto-generated method stub
		return certificateRepository.findOneById(id);
	}
	
	

	@Override
	public Certificate saveCertificate(Certificate certificate) {
		// TODO Auto-generated method stub
		return certificateRepository.save(certificate);
	}


	@Override
	public void removeCertificate(Long id) {
		// TODO Auto-generated method stub
		certificateRepository.deleteById(id);
	}


	@Override
	public Certificate findOneByIdSubject(Long id) {
		// TODO Auto-generated method stub
		return certificateRepository.findOneByIdSubject(id);
	}
	
	@Override
	public Certificate findOneByIdIssuer(Long id) {
		// TODO Auto-generated method stub
		return certificateRepository.findOneByIdIssuer(id);
	}


	@Override
	public Certificate findOneBySerialNumber(BigInteger id) {
		// TODO Auto-generated method stub
		return certificateRepository.findOneBySerialNumber(id);
	}


}
