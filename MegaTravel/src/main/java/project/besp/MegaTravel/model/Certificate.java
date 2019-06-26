package project.besp.MegaTravel.model;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Certificate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="idissuer")
	private Long idIssuer;
	
	@Column(name="idsubject")
	private Long idSubject;
	
	@Column(name="valid_from")
	private Date validFrom;
	
	@Column(name="valid_to")
	private Date validTo;
	
	@Column(name="revoked")
	private boolean revoked;
	
	@Column(name="ca")
	private boolean ca;
	
	@Column(name="reasonforrevokation")
	private String reasonForRevokation;

	@Column(name="serial_number")
	private BigInteger serialNumber;
	
	public Date getValidFrom() {
		return validFrom;
	}



	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}



	public Date getValidTo() {
		return validTo;
	}



	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}



	public BigInteger getSerialNumberr() {
		return serialNumber;
	}



	public void setSerialNumberr(BigInteger serialNumber) {
		this.serialNumber = serialNumber;
	}



	public Certificate() {

	}
	
	

	public Certificate(Long idIssuer, Date validFrom, Date validTo, boolean revoked,
			boolean ca, String reasonForRevokation ,BigInteger serialNumber) {
		super();
		this.idIssuer = idIssuer;
		this.validFrom = validFrom;
		this.validTo = validTo;
		this.revoked = revoked;
		this.ca = ca;
		this.reasonForRevokation = reasonForRevokation;
		this.serialNumber = serialNumber;
	}
	public Certificate(Long idIssuer, Long idSubject, Date validFrom, Date validTo, boolean revoked,
			boolean ca, String reasonForRevokation ,BigInteger serialNumber) {
		super();
		this.idSubject = idSubject;
		this.idIssuer = idIssuer;
		this.validFrom = validFrom;
		this.validTo = validTo;
		this.revoked = revoked;
		this.ca = ca;
		this.reasonForRevokation = reasonForRevokation;
		this.serialNumber = serialNumber;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Long getIdIssuer() {
		return idIssuer;
	}

	public void setIdIssuer(Long idIssuer) {
		this.idIssuer = idIssuer;
	}

	public Long getIdSubject() {
		return idSubject;
	}

	public void setIdSubject(Long idSubject) {
		this.idSubject = idSubject;
	}

	

	public boolean isRevoked() {
		return revoked;
	}

	public void setRevoked(boolean revoked) {
		this.revoked = revoked;
	}

	public String getReasonForRevokation() {
		return reasonForRevokation;
	}

	public void setReasonForRevokation(String reasonForRevokation) {
		this.reasonForRevokation = reasonForRevokation;
	}

	public boolean isCa() {
		return ca;
	}

	public void setCa(boolean ca) {
		this.ca = ca;
	}


}
