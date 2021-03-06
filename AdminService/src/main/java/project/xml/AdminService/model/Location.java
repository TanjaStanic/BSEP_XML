//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.06.11 at 07:32:39 PM CEST 
//


package project.xml.AdminService.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="geoLength">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}float">
 *               &lt;minInclusive value="-180"/>
 *               &lt;maxInclusive value="180"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="geoWidth">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}float">
 *               &lt;minInclusive value="-90"/>
 *               &lt;maxInclusive value="90"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
/*@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "location", propOrder = {
    "geo_length",
    "geo_width"
})*/
@Entity
@Table(name= "location")

@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Location {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id", nullable = false, updatable = false)
    public long id;
	
    @XmlElement(required = true)
    @Column(name = "geo_length", nullable = false)
    public float geoLength;
    
    
    @XmlElement(required = true)
    @Column(name = "geo_width", nullable = false)
    public float geoWidth;
    
    
    /*@OneToOne(mappedBy="location")
    public Accommodation accomodation;*/
    
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public float getGeoLength() {
		return geoLength;
	}

	public void setGeoLength(float geoLength) {
		this.geoLength = geoLength;
	}

	public float getGeoWidth() {
		return geoWidth;
	}

	public void setGeoWidth(float geoWidth) {
		this.geoWidth = geoWidth;
	}

	/*public Accommodation getAccomodation() {
		return accomodation;
	}

	public void setAccomodation(Accommodation accomodation) {
		this.accomodation = accomodation;
	}*/
}
