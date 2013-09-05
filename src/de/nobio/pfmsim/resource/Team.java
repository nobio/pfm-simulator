//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
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


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "team", propOrder = { "id", "resource" })
public class Team {
    @XmlAttribute
    protected String id;
    @XmlElement(nillable = true)
    protected List<Resource> resource;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Resource> getResources() {
        if (this.resource == null) {
            this.resource = new ArrayList<Resource>();
        }
        return this.resource;
    }

    public void appendResource(Resource resource) {
        if (this.resource == null) {
            this.resource = new ArrayList<Resource>();
        }
        this.resource.add(resource);
    }

    @Override
    public String toString() {
        return "\nTeam [id=" + id + ", resource=" + resource + "]";
    }
}
