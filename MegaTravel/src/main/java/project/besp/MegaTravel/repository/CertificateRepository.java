package project.besp.MegaTravel.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.besp.MegaTravel.model.Certificate;


@Repository
public interface CertificateRepository extends JpaRepository<Certificate,Long> {
	Certificate findOneById(Long id);
	Certificate findOneByIdSubject(Long id);
	Certificate findOneByIdIssuer(Long id);
	Certificate findOneBySerialNumber(BigInteger id);


}
