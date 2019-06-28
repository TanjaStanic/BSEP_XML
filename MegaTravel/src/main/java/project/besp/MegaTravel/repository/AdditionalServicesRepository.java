package project.besp.MegaTravel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.besp.MegaTravel.modelxsd.AdditionalServices;


@Repository
public interface AdditionalServicesRepository extends JpaRepository<AdditionalServices, Long> {
	AdditionalServices findByName(String name);
}
