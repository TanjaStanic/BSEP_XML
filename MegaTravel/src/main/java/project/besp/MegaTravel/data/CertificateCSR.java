package project.besp.MegaTravel.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "certificatecsr")
public class CertificateCSR {
	

	@Id
	@GeneratedValue
    @Column(name = "certificatecsr_id", nullable = false, updatable = false)
	private Long id;
	
	@Column(name = "serial", nullable = true)
	private long serial;

	@Column(name = "alias", nullable = true)
	private String alias;

	
	@Column(name="ocsp_valid", nullable = false)
	private boolean ocspValid;

	public CertificateCSR() {
		super();
	}



	public CertificateCSR( long serial, String alias, boolean ocspValid) {
		super();
		
		this.serial = serial;
		this.alias = alias;
		this.ocspValid = ocspValid;
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}



	public long getSerial() {
		return serial;
	}


	public void setSerial(long serial) {
		this.serial = serial;
	}


	public String getAlias() {
		return alias;
	}


	public void setAlias(String alias) {
		this.alias = alias;
	}


	public boolean isOcspValid() {
		return ocspValid;
	}


	public void setOcspValid(boolean ocspValid) {
		this.ocspValid = ocspValid;
	}



}
