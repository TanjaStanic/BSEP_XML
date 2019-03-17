package project.besp.MegaTravel.serviceImpl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project.besp.MegaTravel.model.UserRole;
import project.besp.MegaTravel.model.EmployeeRole;
import project.besp.MegaTravel.model.Employee;
import project.besp.MegaTravel.repository.EmployeeRepository;
import project.besp.MegaTravel.service.EmployeeService;


@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	HttpSession sesija;
	
	@Override
	public Employee registracijaZaposlenog(Employee z) {
		z.role = UserRole.Employee;
		//System.out.println(z.ulogaZ);
		z.employeeRole = EmployeeRole.Office;
		return  employeeRepository.save(z);
	}

	@Override
	public Employee getEmployee (Long id) {		
		return employeeRepository.getOne(id);
	}

}
