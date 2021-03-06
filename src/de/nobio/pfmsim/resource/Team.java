//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB)
// Reference Implementation, vJAXB 2.1.10 in JDK 6
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source
// schema.
// Generated on: 2013.09.01 at 02:14:43 PM MESZ
//

package de.nobio.pfmsim.resource;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "team", propOrder = { "id", "resource" })
public class Team {
    @XmlAttribute(required = true)
    private String id;
    @XmlElement(nillable = true)
    private List<Resource> resource;

    /**
     * Method appendResource.
     * 
     * @param resource
     *            Resource
     */
    public void appendResource(Resource resource) {
        if (this.resource == null) {
            this.resource = new ArrayList<Resource>();
        }
        setNewResourceId(resource);
        this.resource.add(resource);
    }

    /**
     * Method getId.
     * 
     * @return String
     */
    public String getId() {
        return id;
    }

    /**
     * Method getResources.
     * 
     * @return List<Resource>
     */
    public List<Resource> getResources() {
        if (this.resource == null) {
            this.resource = new ArrayList<Resource>();
        }
        for (Resource res : this.resource) {
            setNewResourceId(res);
        }
        return this.resource;
    }

    /**
     * Method getResourceWithSkill.
     * 
     * @param skill
     *            Skill
     * @param period
     *            Period
     * @param workload
     *            Long
     * @return Resource
     */
    public Resource getResourceWithSkill(Skill skill, Period period, Long workload) {
        for (Resource resource : getResources()) {
            for (Skill s : resource.getSkills()) {
                if (s.equals(skill) && resource.getFreeCapacity(period) >= workload) {
                    return resource;
                }
            }
        }
        return null;
    }

    /**
     * Method setId.
     * 
     * @param id
     *            String
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Method setNewResourceId.
     * 
     * @param resource
     *            Resource
     */
    private void setNewResourceId(Resource resource) {
        resource.setId(this.getId() + "." + resource.hashCode());
    }

    /**
     * Method toString.
     * 
     * @return String
     */
    @Override
    public String toString() {
        return "\nTeam [id=" + id + ", resource=" + resource + "]";
    }
}
