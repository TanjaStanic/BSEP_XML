//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.06.09 at 02:26:02 PM CEST 
//


package project.xml.AgentMegaTravel.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="start_date" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="end_date" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="total_price">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}double">
 *               &lt;minExclusive value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element ref="{http://www.mega-travel/user}client"/>
 *         &lt;element ref="{http://www.mega-travel/accommodation-unit}accommodationUnit"/>
 *         &lt;element name="reservationStatus">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="cancelled"/>
 *               &lt;whiteSpace value="preserve"/>
 *               &lt;enumeration value="confirmed"/>
 *               &lt;enumeration value="arrived"/>
 *               &lt;enumeration value="rejected"/>
 *               &lt;enumeration value="pending"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="reservationRating">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="2"/>
 *               &lt;enumeration value="3"/>
 *               &lt;enumeration value="4"/>
 *               &lt;enumeration value="5"/>
 *               &lt;enumeration value="unrated"/>
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
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "id",
    "startDate",
    "endDate",
    "totalPrice",
    "client",
    "accommodationUnit",
    "reservationStatus",
    "reservationRating"
})
@XmlRootElement(name = "reservation", namespace = "http://www.mega-travel/reservation")
public class Reservation {

    @XmlElement(namespace = "http://www.mega-travel/reservation")
    protected long id;
    @XmlElement(name = "start_date", namespace = "http://www.mega-travel/reservation", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar startDate;
    @XmlElement(name = "end_date", namespace = "http://www.mega-travel/reservation", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar endDate;
    @XmlElement(name = "total_price", namespace = "http://www.mega-travel/reservation")
    protected double totalPrice;
    @XmlElement(namespace = "http://www.mega-travel/user", required = true)
    protected Client client;
    @XmlElement(namespace = "http://www.mega-travel/accommodation-unit", required = true)
    protected AccommodationUnit accommodationUnit;
    @XmlElement(namespace = "http://www.mega-travel/reservation", required = true)
    protected String reservationStatus;
    @XmlElement(namespace = "http://www.mega-travel/reservation", required = true, defaultValue = "unrated")
    protected String reservationRating;

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
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartDate(XMLGregorianCalendar value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndDate(XMLGregorianCalendar value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the totalPrice property.
     * 
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * Sets the value of the totalPrice property.
     * 
     */
    public void setTotalPrice(double value) {
        this.totalPrice = value;
    }

    /**
     * Gets the value of the client property.
     * 
     * @return
     *     possible object is
     *     {@link Client }
     *     
     */
    public Client getClient() {
        return client;
    }

    /**
     * Sets the value of the client property.
     * 
     * @param value
     *     allowed object is
     *     {@link Client }
     *     
     */
    public void setClient(Client value) {
        this.client = value;
    }

    /**
     * Gets the value of the accommodationUnit property.
     * 
     * @return
     *     possible object is
     *     {@link AccommodationUnit }
     *     
     */
    public AccommodationUnit getAccommodationUnit() {
        return accommodationUnit;
    }

    /**
     * Sets the value of the accommodationUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccommodationUnit }
     *     
     */
    public void setAccommodationUnit(AccommodationUnit value) {
        this.accommodationUnit = value;
    }

    /**
     * Gets the value of the reservationStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReservationStatus() {
        return reservationStatus;
    }

    /**
     * Sets the value of the reservationStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReservationStatus(String value) {
        this.reservationStatus = value;
    }

    /**
     * Gets the value of the reservationRating property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReservationRating() {
        return reservationRating;
    }

    /**
     * Sets the value of the reservationRating property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReservationRating(String value) {
        this.reservationRating = value;
    }

}
