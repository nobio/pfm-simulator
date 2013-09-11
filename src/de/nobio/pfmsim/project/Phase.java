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

    public Workload getWorkload() {
        return workload;
    }

    public void setWorkload(Workload workload) {
        this.workload = workload;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Phase phase = new Phase();
        phase.setId(id);
        phase.setName(name);
        phase.setRef(ref);
        phase.setWorkload(workload);
        return phase;
    }

    @Override
    public String toString() {
        return "\n\t\tPhase [id=" + id + ", ref=" + ref + ", name=" + name + ", workload=" + workload + "]";
    }

}
