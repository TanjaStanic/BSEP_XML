package project.besp.MegaTravel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.besp.MegaTravel.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
