//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.06.11 at 07:32:39 PM CEST 
//


package project.xml.AdminService.model;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



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
 *         &lt;element name="id">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *               &lt;minInclusive value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="capacity" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="size" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger">
 *               &lt;minInclusive value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="freeCancelation" type="{http://www.mega-travel/accommodation-unit}cancelation"/>
 *         &lt;element name="type">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="hotel"/>
 *               &lt;enumeration value="bed_and_breakfast"/>
 *               &lt;enumeration value="apartment"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element ref="{http://www.mega-travel/accommodation-unit}pricing"/>
 *         &lt;element ref="{http://www.mega-travel/accommodation}accommodation"/>
 *         &lt;element ref="{http://www.mega-travel/accommodation-unit}additional_services" maxOccurs="12" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="number_of_room">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *             &lt;minInclusive value="1"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="floor">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *             &lt;minInclusive value="0"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccommodationUnit", propOrder = {
    "id",
    "capacity",
    "size",
    "freeCancelation",
    "type",
})
@Entity
@Table(name="accommodation_unit")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AccommodationUnit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accommodation_unit_id", nullable = false, updatable = false)
	protected long id;
    
	@XmlElement(required = true)
    protected BigInteger capacity;
	
	@XmlElement(required = true)
	protected Integer number_of_room;
	
	@XmlElement(required = true)
	protected Integer floor;
    
	protected BigInteger size;
   
	@XmlElement(required = true)
    protected String type;
    
	/*
     * Smjestajna jedinica odgovara tacno jednom smjestaju.
     */
	@ManyToOne
	@JoinColumn(name="acc")
	private Accommodation accommodation;
	
	/*
	 * Jedna smjestajna jedinica odgovara jednom agentu
	 * Jedan agent ima vise smjestajnih jedinica
	 */
	@ManyToOne
	@JoinColumn(name="agent_units")
	private User user;
	
	/*
	 * Jedna dodatna usluga moze da odgovora za vise smjestajnih jedinica
	 */
    @ManyToMany
	@JoinTable(
	        name = "accommodation_unit_additional_services", 
	        joinColumns = { @JoinColumn(name = "accommodation_unit_id") }, 
	        inverseJoinColumns = { @JoinColumn(name = "additional_id") }
	    )
    protected List<AdditionalServices> additional_services;
    
    /*
     * SJ se rezervise vise puta
     */
    @OneToMany(mappedBy="accommodation_unit")
    protected List<Reservation> reservations;
    /*
     * ima svoju listu cijena (na mjesecnom nivou pozeljno)
     */
    @OneToMany(mappedBy="accommodation_unit")
    protected List<Pricing> pricing;
    
    @OneToMany(mappedBy="accommodation_unit")
    protected List<Comment> comments;
    /**
     * Gets the value of the id property.
     * 
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(long value) {
        this.id = value;
    }

    /**
     * Gets the value of the capacity property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCapacity() {
        return capacity;
    }

    /**
     * Sets the value of the capacity property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCapacity(BigInteger value) {
        this.capacity = value;
    }

    /**
     * Gets the value of the size property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSize() {
        return size;
    }

    /**
     * Sets the value of the size property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSize(BigInteger value) {
        this.size = value;
    }


    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the pricing property.
     * 
     * @return
     *     possible object is
     *     {@link Pricing }
     *     
     */



    /**
     * Gets the value of the additionalServices property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the additionalServices property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdditionalServices().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AdditionalServices }
     * 
     * 
     */


    /**
     * Gets the value of the numberOfRoom property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumberOfRoom() {
        return number_of_room;
    }

    /**
     * Sets the value of the numberOfRoom property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumberOfRoom(Integer value) {
        this.number_of_room = value;
    }

    /**
     * Gets the value of the floor property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFloor() {
        return floor;
    }

    /**
     * Sets the value of the floor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFloor(Integer value) {
        this.floor = value;
    }

	public Integer getNumber_of_room() {
		return number_of_room;
	}

	public void setNumber_of_room(Integer number_of_room) {
		this.number_of_room = number_of_room;
	}

	public Accommodation getAccommodation() {
		return accommodation;
	}

	public void setAccommodation(Accommodation accommodation) {
		this.accommodation = accommodation;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<AdditionalServices> getAdditional_services() {
		return additional_services;
	}

	public void setAdditional_services(List<AdditionalServices> additional_services) {
		this.additional_services = additional_services;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public List<Pricing> getPricing() {
		return pricing;
	}

	public void setPricing(List<Pricing> pricing) {
		this.pricing = pricing;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	

}