package project.xml.AgentMegaTravel.soap;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import project.xml.AgentMegaTravel.model.Accommodation;
import project.xml.AgentMegaTravel.model.AccommodationRequest;
import project.xml.AgentMegaTravel.model.AccommodationResponse;

public class AccommodationClient extends WebServiceGatewaySupport{
	public AccommodationResponse getCountry(Accommodation accom) {

		AccommodationRequest request = new AccommodationRequest();
		request.setAccommodation(accom);

		AccommodationResponse response = (AccommodationResponse) getWebServiceTemplate()
				.marshalSendAndReceive("https://localhost:8443/accommodation", request,
						new SoapActionCallback(
								"http://www.ftn.uns.ac.rs/MegaTravel/soap/AccommodationRequest"));

		return response;
	}
}
