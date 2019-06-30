package project.xml.AgentMegaTravel.soap;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import project.xml.AgentMegaTravel.xsd.GetAccommodationRequest;
import project.xml.AgentMegaTravel.xsd.GetAccommodationResponse;

public class BaseClient extends WebServiceGatewaySupport{

	public GetAccommodationResponse getAccommodation(Long agentId) {

		GetAccommodationRequest request = new GetAccommodationRequest();
		request.setAgentId(agentId);
		
		System.out.println("getAccommodation in BaseClient entered");

		GetAccommodationResponse response = (GetAccommodationResponse) getWebServiceTemplate()
				.marshalSendAndReceive("https://localhost:8443/ws", request);
		System.out.println("getAccommodation in BaseClient end");
		return response;
	}
	
}
