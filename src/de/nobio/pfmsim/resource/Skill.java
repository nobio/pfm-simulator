package de.nobio.pfmsim.resource;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import de.nobio.pfmsim.project.Distribution;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "skill", propOrder = { "id", "distribution", "ref", "name" })
public class Skill {
    @XmlAttribute
    private String id;

    @XmlAttribute
    private String ref;

    @XmlAttribute
    private String name;

    @XmlElement(type = Distribution.class)
    private Distribution distribution;

    public String getId() {
        return id;
    }

    public String getRef() {
        return ref;
    }

    public Distribution getDistribution() {
        return distribution;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Skill [id=" + id + ", ref=" + ref + ", distribution=" + distribution + ", name=" + name + "]";
    }

}
