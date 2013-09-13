package de.nobio.pfmsim.project;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import de.nobio.pfmsim.distribution.Distribution;
import de.nobio.pfmsim.resource.Skill;
import de.nobio.pfmsim.runtime.TimeClock;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "project")
public class Project implements TimeClock {

    @XmlAttribute(required = true, name = "category_ref")
    private String categoryRef;

    @XmlTransient
    private String priority;

    @XmlElement(type = Category.class)
    private Category category;

    @XmlElement(type = Distribution.class)
    private Distribution distribution;

    @XmlElement(name = "phase", nillable = true, required = true)
    private List<Phase> phases;

    @XmlElement(name = "skill", nillable = true, required = true)
    private List<Skill> neededSkills;

    public String getCategoryRef() {
        return categoryRef;
    }

    public String getPriority() {
        return priority;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * config of project probability
     */
    public Distribution getDistribution() {
        return distribution;
    }

    public List<Phase> getPhases() {
        return phases;
    }

    public void setPhases(List<Phase> phases) {
        this.phases = phases;
    }

    public List<Skill> getSkills() {
        return neededSkills;
    }

    @Override
    public void tick(Long clock) {
        // TODO Auto-generated method stub

    }

    @Override
    public String toString() {
        return "\n\tProject [categoryRef=" + categoryRef + ", priority=" + priority + ", category=" + category + ", distribution=" + distribution + ", phases="
                + phases + ", skills=" + neededSkills + "]";
    }

}
