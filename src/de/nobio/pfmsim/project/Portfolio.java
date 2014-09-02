package de.nobio.pfmsim.project;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import de.nobio.pfmsim.distribution.Distribution;

/**
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "portfolio")
public class Portfolio {

    @XmlElement(name = "project", nillable = true, required = true)
    private List<Project> projects;

    @XmlElement(name = "distribution", required = true)
    private Distribution projectCategoryStartProbability;

    /**
     * Method getProjectCategoryStartProbability.
     * 
     * @return Distribution
     */
    public Distribution getProjectCategoryStartProbability() {
        return projectCategoryStartProbability;
    }

    /**
     * Method getProjects.
     * 
     * @return List<Project>
     */
    public List<Project> getProjects() {
        return projects;
    }

    /**
     * Method setProjectCategoryStartProbability.
     * 
     * @param projectCategoryStartProbability
     *            Distribution
     */
    public void setProjectCategoryStartProbability(Distribution projectCategoryStartProbability) {
        this.projectCategoryStartProbability = projectCategoryStartProbability;
    }

    /**
     * Method setProjects.
     * 
     * @param projects
     *            List<Project>
     */
    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    /**
     * Method toString.
     * 
     * @return String
     */
    @Override
    public String toString() {
        return "Portfolio [projects=" + projects + ", projectCategoryStartProbability=" + projectCategoryStartProbability + "]";
    }

}
