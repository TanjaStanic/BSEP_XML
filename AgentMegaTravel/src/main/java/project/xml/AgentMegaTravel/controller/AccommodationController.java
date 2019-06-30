package project.xml.AgentMegaTravel.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import project.xml.AgentMegaTravel.model.Accommodation;
import project.xml.AgentMegaTravel.model.User;
import project.xml.AgentMegaTravel.repository.AccommodationRepository;
import project.xml.AgentMegaTravel.soap.BaseClient;
import project.xml.AgentMegaTravel.xsd.AccommodationUnit;
import project.xml.AgentMegaTravel.xsd.AdditionalServices;
import project.xml.AgentMegaTravel.xsd.GetAccommodationUnitResponse;

@RestController
@RequestMapping("/api/accommodation")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4201","http://localhost:4202"})
public class AccommodationController {
	
	@Autowired
	private BaseClient baseClient;
	
	@Autowired 
	AccommodationRepository accommodationRepository;
	
	@RequestMapping(value="/getAccommodations/{id}", 
			method = RequestMethod.GET)
	public ResponseEntity<?> getAcommodationsOfAgent(@PathVariable("id") Long agentId){
	
		System.out.println("Usao u accommodation controller - get acc of agents");
		List<Accommodation> allAcc = accommodationRepository.findAll();
		List<Accommodation> accOfAgent = new ArrayList<Accommodation>();
		
		for(int i=0; i<allAcc.size();i++)
		{
			Accommodation a = allAcc.get(i);
			if(a.getUser()!=null)
			{
				
					User ag = a.getUser();
					if(ag.getId().equals(agentId))
					{
						accOfAgent.add(a);
					}
				
			}
		}
		
		System.out.println("Acc of agents: " + accOfAgent.size());
		/*List<AccommodationDTO> dtos = new ArrayList<AccommodationDTO>();
		
		for(Accommodation acc: accOfAgent)
		{
			System.out.println("Name " + acc.getName());
			
			AccommodationDTO dto = new AccommodationDTO(acc.getId(), acc.getName(), acc.getAddress().getStreet(), acc.getAddress().getNumber(), 
					acc.getAddress().getCity(), acc.getAddress().getState(),acc.getType().getName(), acc.getDescription());
			System.out.println("DTO " + dto.getId() + " " + dto.getName() + " " + dto.getStreet() + " " + dto.getNumber() + " " + dto.getCity() + " " + dto.getState() + " "
					+ dto.getType() + " " + dto.getDescription());
			dtos.add(dto);
			
		}*/
		return new ResponseEntity<List<Accommodation>>(accOfAgent, HttpStatus.OK);
	}


}
