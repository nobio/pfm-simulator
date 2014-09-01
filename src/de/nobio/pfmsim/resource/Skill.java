package de.nobio.pfmsim.resource;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import de.nobio.pfmsim.distribution.Distribution;

/**
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "skill", propOrder = { "id", "distribution", "ref", "name" })
public class Skill {
    @XmlAttribute
    private String id;

    @XmlAttribute
    private String ref;

    @XmlAttribute
    private String name;

    @XmlElement(type = Distribution.class, name = "distribution")
    private Distribution distribution;

    /**
     * Method getId.
     * @return String
     */
    public String getId() {
        return id;
    }

    /**
     * Method setId.
     * @param id String
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Method getRef.
     * @return String
     */
    public String getRef() {
        return ref;
    }

    /**
     * Method setRef.
     * @param ref String
     */
    public void setRef(String ref) {
        this.ref = ref;
    }

    /**
     * Method getName.
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Method setName.
     * @param name String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method getDistribution.
     * @return Distribution
     */
    public Distribution getDistribution() {
        return distribution;
    }

    /**
     * Method setDistribution.
     * @param distribution Distribution
     */
    public void setDistribution(Distribution distribution) {
        this.distribution = distribution;
    }

    /**
     * Method hashCode.
     * @return int
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    /**
     * Method equals.
     * @param obj Object
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Skill other = (Skill) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    /**
     * Method toString.
     * @return String
     */
    @Override
    public String toString() {
        return "\n\t\tSkill [id=" + id + ", ref=" + ref + ", distribution=" + distribution + ", name=" + name + "]";
    }

}
