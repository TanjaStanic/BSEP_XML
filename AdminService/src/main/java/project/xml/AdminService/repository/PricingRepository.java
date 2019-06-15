package project.xml.AdminService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.xml.AdminService.model.Pricing;

@Repository
public interface PricingRepository extends JpaRepository<Pricing, Long>{

}
