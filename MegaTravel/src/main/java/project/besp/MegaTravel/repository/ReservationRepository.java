package project.besp.MegaTravel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import project.besp.MegaTravel.modelxsd.Reservation;


@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
	
	@Transactional
	@Query(value="SELECT * FROM Reservation reservation WHERE reservation.reservation_id = ?1",  nativeQuery = true)
	List<Reservation> findByRoomId(Long id);
	
	@Transactional
	@Query(value="SELECT * FROM Reservation reservation WHERE reservation.reservation_user = ?1",  nativeQuery = true)
	List<Reservation> findByClientId(Long id);

}
