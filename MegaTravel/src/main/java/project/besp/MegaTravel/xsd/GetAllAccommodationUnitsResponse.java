package project.besp.MegaTravel.xsd;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "accommodationUnit"
})
@XmlRootElement(name = "GetAllAccommodationUnitsReposnse")
public class GetAllAccommodationUnitsResponse {
	@XmlElement(name = "accommodation_unit")
    protected List<AccommodationUnit> accommodationUnit;

	public List<AccommodationUnit> getAccommodationUnit() {
		return accommodationUnit;
	}

	public void setAccommodationUnit(List<AccommodationUnit> accommodationUnit) {
		this.accommodationUnit = accommodationUnit;
	}

	
}
