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
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "resource")
public class Resource {

    @XmlTransient
    private String id;

    @XmlElement(required = false)
    private Double baseAvailability = 0.0D;

    @XmlAttribute(required = true)
    private Integer count = 0;

    @XmlTransient
    private Double reserved = 0.0D;

    @XmlElement(name = "skill", nillable = true, required = true)
    private List<Skill> skills;

    @XmlTransient
    private Plan plan;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getBaseAvailability() {
        return baseAvailability;
    }

    public void setBaseAvailability(Double availability) {
        this.baseAvailability = availability;
    }

    public Double getReserved() {
        return reserved;
    }

    public void setReserved(Double reserved) {
        this.reserved = reserved;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Skill> getSkills() {
        if (skills == null) {
            skills = new ArrayList<Skill>();
        }
        return this.skills;
    }

    public void addSkill(Skill skill) {
        getSkills().add(skill);
    }

    public Plan getPlan() {
        return plan;
    }

    public Long getFreeCapacity() {
        if(plan == null) {
            plan = new Plan(baseAvailability);
        }
        return plan.getFreeCapacity();
    }
    
    @Override
    protected Resource clone() throws CloneNotSupportedException {
        Resource r = new Resource();
        r.setBaseAvailability(new Double(baseAvailability));
        r.setCount(new Integer(count));
        r.getSkills().addAll(skills);
        return r;
    }

    @Override
    public String toString() {
        return "\n\tResource [id=" + id + ", baseAvailability=" + baseAvailability + ", count=" + count + ", reserved=" + reserved + ", skills=" + skills + "]";
    }

}
