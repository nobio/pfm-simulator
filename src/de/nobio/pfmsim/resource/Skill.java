package de.nobio.pfmsim.resource;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "skill", propOrder = { "id", "weight", "ref", "name" })
public class Skill {
    @XmlAttribute
    private String id;
    @XmlAttribute
    private String ref;
    @XmlAttribute
    private Double weight;
    @XmlValue
    private String name;

    public String getId() {
        return id;
    }

    public String getRef() {
        return ref;
    }

    public Double getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Skill [id=" + id + ", ref=" + ref + ", weight=" + weight + ", name=" + name + "]";
    }

    /*
    @Override
    public String toString() {
        String idString = id != null ? "id=" + id : "";
        String nameString = name != null && !name.isEmpty() ? "name=" + name : "";
        String refString = ref != null ? "ref=" + ref : "";
        String weightString = weight != null ? "weight=" + weight : "";

        return "Skill [" + refString + " " + idString + " " + weightString + " " + nameString + "(@" + this.hashCode() + ")" + "]";
    }
    */
    
}
