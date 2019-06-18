package project.xml.AgentMegaTravel.soap;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import project.xml.AgentMegaTravel.xsd.*;
import project.xml.AgentMegaTravel.xsd.GetAccommodationResponse;


public class AccommodationClient extends WebServiceGatewaySupport{
	
	public GetAccommodationResponse getAccommodation(Long id) {
		GetAccommodationRequest request = new GetAccommodationRequest();
		request.setId(id);
		return (GetAccommodationResponse) getWebServiceTemplate().marshalSendAndReceive(request);

	}
	public GetAddressResponse getAddress(Long id) {
		GetAddressRequest request = new GetAddressRequest();
		request.setId(1);
		return (GetAddressResponse) getWebServiceTemplate().marshalSendAndReceive(request);
	}
	public GetAdditionalServiceResponse getAdditionalService(Long id) {
		GetAdditionalServiceRequest request = new GetAdditionalServiceRequest();
		request.setId(1);
		return (GetAdditionalServiceResponse) getWebServiceTemplate().marshalSendAndReceive(request);
	}
	public GetAllAdditionalServiceResponse getAllAdditionalServiceResponse() {
		GetAllAdditionalServiceRequest request = new GetAllAdditionalServiceRequest();
		return (GetAllAdditionalServiceResponse) getWebServiceTemplate().marshalSendAndReceive(request);
	}
	public GetPricingResponse getAccUnitPrice(Long id) {
		GetPricingRequest request = new GetPricingRequest();
		request.setId(1);
		return (GetPricingResponse) getWebServiceTemplate().marshalSendAndReceive(request);
	}
	public GetAccommodationUnitResponse saveNewAcc(AccommodationUnit au) {
		GetAccommodationUnitRequest request = new GetAccommodationUnitRequest();
		request.setAccommodationUnit(au);
		return (GetAccommodationUnitResponse) getWebServiceTemplate().marshalSendAndReceive(request);
	}
}
