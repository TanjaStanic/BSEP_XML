package project.besp.MegaTravel.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class WithDrawCert implements Serializable {
	
	private static final long serialVersionUID = 6390650937383741213L;

	@Id		
    @GeneratedValue
    public Long id;
	
	@Column
	String serialNumber;
	
	@Column
	String status;
	
	
	
	public WithDrawCert(String serialNumber) {
		super();
		this.serialNumber = serialNumber;
		this.status = "povucen";
	}

	public WithDrawCert() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

}
