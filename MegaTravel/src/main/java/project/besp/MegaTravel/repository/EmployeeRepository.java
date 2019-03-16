package project.besp.MegaTravel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.besp.MegaTravel.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
