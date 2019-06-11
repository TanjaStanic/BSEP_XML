package project.xml.ReservationService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.xml.ReservationService.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {

}
