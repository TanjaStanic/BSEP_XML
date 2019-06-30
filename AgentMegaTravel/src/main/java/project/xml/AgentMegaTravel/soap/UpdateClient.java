package project.xml.AgentMegaTravel.soap;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import project.xml.AgentMegaTravel.xsd.AccommodationUnit;
import project.xml.AgentMegaTravel.xsd.SaveAccommodationUnitRequest;
import project.xml.AgentMegaTravel.xsd.SaveAccommodationUnitResponse;

public class UpdateClient extends WebServiceGatewaySupport{
	
	public SaveAccommodationUnitResponse saveAccUnit(AccommodationUnit accUnit) {
		
		SaveAccommodationUnitRequest request = new SaveAccommodationUnitRequest();
		request.setAccommodationUnit(accUnit);
		
		System.out.println("saveRoom in UpdateClient entered");
		
		SaveAccommodationUnitResponse response = (SaveAccommodationUnitResponse) getWebServiceTemplate()
				//.marshalSendAndReceive("https://localhost:8443/ws",request);
				.marshalSendAndReceive(request);

		System.out.println("saveRoom in UpdateClient done");
		
		return response;
	}
}
