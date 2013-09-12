package de.nobio.pfmsim.project;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import de.nobio.pfmsim.distribution.Distribution;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "portfolio", propOrder = { "projectStartDistribution", "projects" })
public class Portfolio {

    @XmlElement(name = "distribution", required = true)
    private Distribution projectStartDistribution;

    @XmlElement(name = "project", nillable = true, required = true)
    private List<Project> projects;

    public Distribution getProjectStartDistribution() {
        return projectStartDistribution;
    }

    public List<Project> getProjects() {
        return projects;
    }

    @Override
    public String toString() {
        return "\nPortfolio [projectStartDistribution=" + projectStartDistribution + ", projects=" + projects + "]";
    }

}
