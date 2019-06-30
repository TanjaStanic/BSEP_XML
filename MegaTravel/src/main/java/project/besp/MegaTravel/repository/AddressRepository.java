package project.besp.MegaTravel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import project.besp.MegaTravel.modelxsd.Accommodation;
import project.besp.MegaTravel.modelxsd.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{
	
	Address findOneByAccommodation(Accommodation a);
	
	@Transactional
	@Query(value="SELECT * FROM Address address WHERE address.street = ?1 and address.number = ?2 and address.city = ?3 and address.state = ?4",  nativeQuery = true)
	Address getByStreetNumberCityPTTState(String street, String number,
			String city, String state);

	@Transactional
	@Query(value="SELECT * FROM Address address WHERE address.city like ?1",  nativeQuery = true)
	List<Address> getByCityName(String string);

}
