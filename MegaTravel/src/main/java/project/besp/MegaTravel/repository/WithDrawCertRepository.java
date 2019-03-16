package project.besp.MegaTravel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.besp.MegaTravel.data.WithDrawCert;

@Repository
public interface WithDrawCertRepository extends JpaRepository<WithDrawCert, Long>  {
	WithDrawCert findBySerialNumber(String serial);

}
