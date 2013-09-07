package de.nobio.pfmsim.project;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "phase", propOrder = { "id", "name", "effortDistribution" })
public class Phase {

    @XmlAttribute(required = true)
    private String id;
    
    @XmlElement(required = true)
    private String name;
    
    @XmlElement(name = "distribution", nillable = true, required = true)
    private List<Distribution> effortDistribution;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Distribution> getEffortDistribution() {
        return effortDistribution;
    }

    @Override
    public String toString() {
        return "Phase [id=" + id + ", name=" + name + ", effortDistribution=" + effortDistribution + "]";
    }

}
