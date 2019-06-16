package project.xml.AgentMegaTravel.soap;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import project.xml.AgentMegaTravel.model.AccommodationRequest;
import project.xml.AgentMegaTravel.model.AccommodationResponse;
import project.xml.AgentMegaTravel.model.AccommodationUnit;
import project.xml.AgentMegaTravel.model.AccommodationUnitRequest;
import project.xml.AgentMegaTravel.model.AccommodationUnitResponse;

import project.xml.AgentMegaTravel.model.AdditionalServiceRequest;
import project.xml.AgentMegaTravel.model.AdditionalServiseResponse;

import project.xml.AgentMegaTravel.model.AddressRequest;
import project.xml.AgentMegaTravel.model.AddressResponse;

public class AccommodationClient extends WebServiceGatewaySupport{
	public AccommodationResponse getAccommodation(Long id) {
		AccommodationRequest request = new AccommodationRequest();
		request.setId(id);
		return (AccommodationResponse) getWebServiceTemplate().marshalSendAndReceive(request);
	}
	public AddressResponse getAddress(Long id) {
		AddressRequest request = new AddressRequest();
		request.setId(1);
		return (AddressResponse) getWebServiceTemplate().marshalSendAndReceive(request);
	}
	public AdditionalServiseResponse getAdditionalService(Long id) {
		AdditionalServiceRequest request = new AdditionalServiceRequest();
		request.setId(1);
		return (AdditionalServiseResponse) getWebServiceTemplate().marshalSendAndReceive(request);
	}
	public AccommodationUnitResponse saveNewAcc(AccommodationUnit au) {
		AccommodationUnitRequest request = new AccommodationUnitRequest();
		request.setAccommodationUnit(au);
		return (AccommodationUnitResponse) getWebServiceTemplate().marshalSendAndReceive(request);
	}
}
