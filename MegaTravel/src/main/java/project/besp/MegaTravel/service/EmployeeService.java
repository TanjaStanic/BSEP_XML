package project.besp.MegaTravel.service;

import org.springframework.stereotype.Service;


import project.besp.MegaTravel.model.Employee;
@Service
public interface EmployeeService {
	
	Employee registracijaZaposlenog(Employee z);

	Employee getEmployee(Long id);

}
