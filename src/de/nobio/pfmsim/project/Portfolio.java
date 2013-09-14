package de.nobio.pfmsim.project;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import de.nobio.pfmsim.distribution.Distribution;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "portfolio")
public class Portfolio {

    @XmlElement(name = "project", nillable = true, required = true)
    private List<Project> projects;

    @XmlElement(name = "distribution", required = true)
    private Distribution projectCategoryStartProbability;

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Distribution getProjectCategoryStartProbability() {
        return projectCategoryStartProbability;
    }

    public void setProjectCategoryStartProbability(Distribution projectCategoryStartProbability) {
        this.projectCategoryStartProbability = projectCategoryStartProbability;
    }

    @Override
    public String toString() {
        return "Portfolio [projects=" + projects + ", projectCategoryStartProbability=" + projectCategoryStartProbability + "]";
    }

}
