package de.nobio.pfmsim.project;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import de.nobio.pfmsim.distribution.Distribution;
import de.nobio.pfmsim.resource.Resource;
import de.nobio.pfmsim.runtime.TimeClock;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "project")
public class Project implements TimeClock, Comparable<Project> {

    @XmlAttribute(required = true, name = "category_ref")
    private String categoryRef;

    @XmlTransient
    private Long priority;

    @XmlElement(type = Category.class)
    private Category category;

    @XmlElement(type = Distribution.class)
    private Distribution distribution;

    @XmlElement(name = "phase", nillable = true, required = true)
    private List<Phase> phases;

    @XmlTransient
    private List<Resource> resources;

    public String getCategoryRef() {
        return categoryRef;
    }

    public Long getPriority() {
        return priority;
    }

    public void setPriority(Long priority) {
        this.priority = priority;
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

    public List<Resource> getResources() {
        if (resources == null) {
            resources = new ArrayList<Resource>();
        }
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

    public void addResource(Resource resource) {
        getResources().add(resource);
    }

    @Override
    public void tick(Long clock) {
        // TODO Auto-generated method stub

    }

    @Override
    public int compareTo(Project p1) {
        int cmp = 0;
        if (p1 == null) {
            cmp = 0;
        } else if (p1.getPriority() > getPriority()) {
            cmp = 1;
        } else if (p1.getPriority() < getPriority()) {
            cmp = -1;
        } else if (p1.getPriority() == getPriority()) {
            cmp = 0;
        }
        return cmp;
    }

    @Override
    public String toString() {
        return "\n\tProject [categoryRef=" + categoryRef + ", priority=" + priority + ", category=" + category + ", distribution=" + distribution + ", phases=" + phases
                + ", skills=" + resources + "]";
    }

}
