package de.nobio.pfmsim.project;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import de.nobio.pfmsim.TimeClock;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "project", propOrder = { "categoryRef", "weight", "workload", "category" })
public class Project implements TimeClock {

    @XmlAttribute(required = true, name = "category_ref")
    private String categoryRef;

    private Category category;

    @XmlAttribute(name = "weight")
    private Integer weight = 0;

    @XmlElement(name = "workload", required = true)
    private Workload workload;

    public String getCategoryRef() {
        return categoryRef;
    }

    public Category getCategory() {
        return category;
    }

    public Integer getWeight() {
        return weight;
    }

    public Workload getWorkload() {
        return workload;
    }

    @Override
    public void tick(Long clock) {
        // TODO Auto-generated method stub

    }

    @Override
    public String toString() {
        return "\n\tProject [categoryRef=" + categoryRef + ", category=" + category + ", weight=" + weight + ", workload=" + workload + "]";
    }

}
