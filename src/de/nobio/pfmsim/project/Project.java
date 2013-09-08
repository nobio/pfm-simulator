package de.nobio.pfmsim.project;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import de.nobio.pfmsim.TimeClock;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "project", propOrder = { "categoryRef", "priority", "distribution", "category", "phases" })
public class Project implements TimeClock {

    @XmlAttribute(required = true, name = "category_ref")
    private String categoryRef;

    @XmlAttribute(required = true, name = "priority")
    private String priority;

    private Category category;

    @XmlElement(type = Distribution.class)
    private Distribution distribution;
    
    @XmlElement(name = "phase", nillable = true, required = true)
    private List<Phase> phases;

    public String getCategoryRef() {
        return categoryRef;
    }

    public String getPriority() {
        return priority;
    }

    public Category getCategory() {
        return category;
    }

    public Distribution getDistribution() {
        return distribution;
    }

    public List<Phase> getPhases() {
        return phases;
    }

    @Override
    public void tick(Long clock) {
        // TODO Auto-generated method stub

    }

    @Override
    public String toString() {
        return "\n\tProject [categoryRef=" + categoryRef + ", priority=" + priority + ", category=" + category + ", distribution=" + distribution + ", phases=" + phases + "]";
    }

}
