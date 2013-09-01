//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.09.01 at 02:14:43 PM MESZ 
//


package de.nobio.pfmsim.config;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for simulation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="simulation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="availability" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="iterations" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="teams" type="{}team" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "simulation", propOrder = {
    "availability",
    "iterations",
    "teams"
})
public class Simulation {

    protected Double availability;
    protected Double iterations;
    @XmlElement(nillable = true)
    protected List<Team> teams;

    /**
     * Gets the value of the availability property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getAvailability() {
        return availability;
    }

    /**
     * Sets the value of the availability property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setAvailability(Double value) {
        this.availability = value;
    }

    /**
     * Gets the value of the iterations property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getIterations() {
        return iterations;
    }

    /**
     * Sets the value of the iterations property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setIterations(Double value) {
        this.iterations = value;
    }

    /**
     * Gets the value of the teams property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the teams property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTeams().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Team }
     * 
     * 
     */
    public List<Team> getTeams() {
        if (teams == null) {
            teams = new ArrayList<Team>();
        }
        return this.teams;
    }

}