package project.besp.MegaTravel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.besp.MegaTravel.data.CertificateCSR;

@Repository
public interface CertificateCSRRepository extends JpaRepository<CertificateCSR, Long>{

}
