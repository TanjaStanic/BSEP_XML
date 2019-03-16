package project.besp.MegaTravel.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "with_draw_cert")
public class WithDrawCert implements Serializable {
	
	private static final long serialVersionUID = 6390650937383741213L;

	@Id		
    @GeneratedValue
    @Column(name = "with_draw_cert_id", nullable = false, updatable = false)
    public Long id;
	
	@Column(name="serial_number")
	String serialNumber;
	
	@Column(name="status")
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
