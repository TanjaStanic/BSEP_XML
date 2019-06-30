package project.besp.MegaTravel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.besp.MegaTravel.modelxsd.Pricing;

@Repository
public interface PricingRepository extends JpaRepository<Pricing,Long>{
	Pricing save(Pricing p);
}
