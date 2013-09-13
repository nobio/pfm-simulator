package de.nobio.pfmsim.project;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import de.nobio.pfmsim.distribution.Distribution;
import de.nobio.pfmsim.resource.Skill;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "project_category")
public class Category {

    @XmlAttribute(required = true)
    private String id;

    @XmlElement(required = true)
    private String name;

    @XmlElement(name = "distribution", required = true)
    private Distribution projectCategoryStartProbability;

    @XmlElement(name = "phase", nillable = true, required = true)
    private List<Phase> phases;

    @XmlElement(name = "skill", nillable = true, required = true)
    private List<Skill> neededSkills;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Distribution getProjectCategoryStartProbability() {
        return projectCategoryStartProbability;
    }

    public void setProjectCategoryStartProbability(Distribution projectCategoryStartProbability) {
        this.projectCategoryStartProbability = projectCategoryStartProbability;
    }

    public List<Phase> getPhases() {
        return phases;
    }

    public void setPhases(List<Phase> phases) {
        this.phases = phases;
    }

    public List<Skill> getNeededSkills() {
        return neededSkills;
    }

    public void setNeededSkills(List<Skill> neededSkills) {
        this.neededSkills = neededSkills;
    }

    @Override
    public String toString() {
        return "\nCategory [id=" + id + ", name=" + name + ", projectCategoryStartProbability=" + projectCategoryStartProbability + ", phases=" + phases
                + ", neededSkills=" + neededSkills + "]";
    }

}
