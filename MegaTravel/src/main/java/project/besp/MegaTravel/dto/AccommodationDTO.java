package project.besp.MegaTravel.dto;

import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;


public class AccommodationDTO {
	
	protected Long id;
	protected String name;
	protected String street;
	protected BigInteger number;
	protected String city;
	protected String state;
	protected String description;
	protected List<AccommodationUnitDTO> rooms;
	protected double distance;
	protected double stars;
	
	public AccommodationDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public AccommodationDTO(Long id, String name, String street, BigInteger number,
			String city, String state, String description, List<AccommodationUnitDTO> rooms,double stars) {
		super();
		this.id = id;
		this.name = name;
		this.street = street;
		this.number = number;
		this.city = city;
		this.state = state;
		this.description = description;
		this.rooms = rooms;
		this.stars = stars;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public BigInteger getNumber() {
		return number;
	}
	public void setNumber(BigInteger number) {
		this.number = number;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}


	public List<AccommodationUnitDTO> getRooms() {
		return rooms;
	}


	public void setRooms(List<AccommodationUnitDTO> rooms) {
		this.rooms = rooms;
	}


	public double getDistance() {
		return distance;
	}


	public void setDistance(double distance) {
		this.distance = distance;
	}


	public double getStars() {
		return stars;
	}


	public void setStars(double stars) {
		this.stars = stars;
	}
	
	
	 

}
