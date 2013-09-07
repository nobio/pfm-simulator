package de.nobio.pfmsim.project;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "project_category", propOrder = { "id", "name", "effortDistribution" })
public class Category {

    @XmlAttribute(required = true)
    private String id;
    @XmlElement(required = true)
    private String name;
    @XmlElement(name="effort_distribution", nillable = true, required = true)
    protected List<EffortDistribution> effortDistribution;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<EffortDistribution> getEffortDistribution() {
        return effortDistribution;
    }

    @Override
    public String toString() {
        return "Category [id=" + id + ", name=" + name + ", effortDistribution=" + effortDistribution + "]";
    }

}
