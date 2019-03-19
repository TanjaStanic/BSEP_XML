package project.besp.MegaTravel.controller;

import java.util.Iterator;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.besp.MegaTravel.model.Employee;
import project.besp.MegaTravel.model.Privilege;
import project.besp.MegaTravel.model.Role;
import project.besp.MegaTravel.model.User;
import project.besp.MegaTravel.service.ClientService;
import project.besp.MegaTravel.service.EmployeeService;
import project.besp.MegaTravel.service.UserService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	HttpSession session;
	
	@GetMapping(path = "/getEmployee")
	public ResponseEntity<Employee> getEmployee() {
		
		if(authorize("preuzmiZaposlenog") == false)
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		User user = (User) session.getAttribute("user");
		return new ResponseEntity<Employee>(employeeService.getEmployee(user.id), HttpStatus.OK);
	}

	public boolean authorize(String operationName) {

		if ((User) session.getAttribute("user") == null) {
			System.out.println("ne postoji user u sesiji !");
			return false;
		}
		User user = (User) session.getAttribute("user");
		System.out.println("postoji user u sesiji !");
		 
		
		Iterator<Role> iterator = user.roles.iterator();
		System.out.println("uzeo iterator");
		
		
		while (iterator.hasNext()) {
			System.out.println("petlja za privilegije");
			Iterator<Privilege> it = iterator.next().privileges.iterator();

			while (it.hasNext()) {
				
				
				System.out.println(operationName);
				System.out.println(it.next().name.toString());
				System.out.println(it.next().name);
				if (it.next().name.equals(operationName)) {
					return true;
				}
				if (it.next().name.toString().equals(operationName)) {
					return true;

				}
			}
		}
		return false;
	}
}
