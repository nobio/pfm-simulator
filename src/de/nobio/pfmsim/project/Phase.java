package de.nobio.pfmsim.project;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "phase", propOrder = { "id", "ref", "name", "workload" })
public class Phase {

    @XmlAttribute(required = true)
    private String id;

    @XmlAttribute(required = true)
    private String ref;

    @XmlElement(required = true)
    private String name;

    @XmlElement(name = "workload", nillable = true, required = true)
    private Workload workload;

    public String getId() {
        return id;
    }

    public String getRef() {
        return ref;
    }

    public String getName() {
        return name;
    }

    public Workload getWorkload() {
        return workload;
    }

    @Override
    public String toString() {
        return "Phase [id=" + id + ", ref=" + ref + ", name=" + name + ", workload=" + workload + "]";
    }

}
