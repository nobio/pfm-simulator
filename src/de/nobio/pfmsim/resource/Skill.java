package de.nobio.pfmsim.resource;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "skill", propOrder = { "id", "name" })
public class Skill {
    @XmlAttribute
    private String id;
    @XmlAttribute
    private String ref;
    @XmlValue
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        String idString = id != null ? "id=" + id : "";
        String nameString = name != null && !name.isEmpty() ? "name=" + name : "";
        String refString = ref != null ? "ref=" + ref : "";

        return "Skill [" + idString + " " + refString + " " + nameString + "(@" + this.hashCode() + ")" + "]";
    }

}
