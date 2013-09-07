package de.nobio.pfmsim.project;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "portfolio", propOrder = { "projects" })
public class Portfolio {

    @XmlElement(name = "project", nillable = true, required = true)
    private List<Project> projects;

    public List<Project> getProjects() {
        return projects;
    }

    @Override
    public String toString() {
        return "\nPortfolio [projects=" + projects + "]";
    }

}
