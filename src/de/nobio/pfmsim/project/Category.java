package de.nobio.pfmsim.project;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import de.nobio.pfmsim.distribution.Distribution;
import de.nobio.pfmsim.resource.Skill;

/**
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "project_category")
public class Category {

    @XmlAttribute(required = true)
    private String id;

    @XmlElement(required = true)
    private String name;

    @XmlElement(name = "distribution", required = true)
    private Distribution projectCategoryDistribution;

    @XmlElement(name = "project_duration", required = true)
    private ProjectDuration projectDuration;

    @XmlElement(name = "phase", nillable = true, required = true)
    private List<Phase> phases;

    @XmlElement(name = "skill", nillable = true, required = true)
    private List<Skill> neededSkills;

    /**
     * Method getId.
     * 
     * @return String
     */
    public String getId() {
        return id;
    }

    /**
     * Method getName.
     * 
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Method getNeededSkills.
     * 
     * @return List<Skill>
     */
    public List<Skill> getNeededSkills() {
        return neededSkills;
    }

    /**
     * Method getPhases.
     * 
     * @return List<Phase>
     */
    public List<Phase> getPhases() {
        return phases;
    }

    /**
     * Method getProjectCategoryDistribution.
     * 
     * @return Distribution
     */
    public Distribution getProjectCategoryDistribution() {
        return projectCategoryDistribution;
    }

    /**
     * Method getProjectDuration.
     * 
     * @return ProjectDuration
     */
    public ProjectDuration getProjectDuration() {
        return projectDuration;
    }

    /**
     * Method setName.
     * 
     * @param name
     *            String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method setNeededSkills.
     * 
     * @param neededSkills
     *            List<Skill>
     */
    public void setNeededSkills(List<Skill> neededSkills) {
        this.neededSkills = neededSkills;
    }

    /**
     * Method setPhases.
     * 
     * @param phases
     *            List<Phase>
     */
    public void setPhases(List<Phase> phases) {
        this.phases = phases;
    }

    /**
     * Method setProjectCategoryDistribution.
     * 
     * @param projectCategoryStartProbability
     *            Distribution
     */
    public void setProjectCategoryDistribution(Distribution projectCategoryStartProbability) {
        this.projectCategoryDistribution = projectCategoryStartProbability;
    }

    /**
     * Method setProjectDuration.
     * 
     * @param projectDuration
     *            ProjectDuration
     */
    public void setProjectDuration(ProjectDuration projectDuration) {
        this.projectDuration = projectDuration;
    }

    /**
     * Method toString.
     * 
     * @return String
     */
    @Override
    public String toString() {
        return "\nCategory [id=" + id + ", name=" + name + ", projectCategoryDistribution=" + projectCategoryDistribution + ", projectDuration=" + projectDuration + ", phases="
                + phases + ", neededSkills=" + neededSkills + "]";
    }

}
