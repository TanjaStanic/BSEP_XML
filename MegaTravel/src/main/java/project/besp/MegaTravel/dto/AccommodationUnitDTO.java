package project.besp.MegaTravel.dto;

public class AccommodationUnitDTO {
	
	protected Long id;
	
    protected int capacity;
    
    protected double defaultPrice;
    
    public AccommodationUnitDTO() {}

	public AccommodationUnitDTO(Long id, int capacity) {
		super();
		this.id = id;
		this.capacity = capacity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public double getDefaultPrice() {
		return defaultPrice;
	}

	public void setDefaultPrice(double defaultPrice) {
		this.defaultPrice = defaultPrice;
	}
    
    
    

}
