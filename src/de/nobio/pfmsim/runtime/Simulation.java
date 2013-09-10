//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB)
// Reference Implementation, vJAXB 2.1.10 in JDK 6
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source
// schema.
// Generated on: 2013.09.01 at 02:14:43 PM MESZ
//

package de.nobio.pfmsim.runtime;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import de.nobio.pfmsim.project.Category;
import de.nobio.pfmsim.project.Phase;
import de.nobio.pfmsim.project.Portfolio;
import de.nobio.pfmsim.resource.Skill;
import de.nobio.pfmsim.resource.Team;

@XmlRootElement(name = "simulation")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "simulation", propOrder = { "availability", "iterations", "pause", "planningHorizont", "skillPool", "projectCategoryPool", "phasePool", "teams",
        "portfolio" })
public class Simulation {

    @XmlElement(required = true)
    private Double availability;

    @XmlElement(required = true)
    private Long iterations;

    @XmlElement(required = true)
    private Long pause;

    @XmlElement(required = true, name = "planning_horizont")
    private Long planningHorizont;

    @XmlElement(nillable = true, name = "skill")
    private List<Skill> skillPool;

    @XmlElement(nillable = true, name = "project_category")
    private List<Category> projectCategoryPool;

    @XmlElement(nillable = true, name = "phase")
    private List<Phase> phasePool;

    @XmlElement(nillable = true, name = "team")
    private List<Team> teams;

    @XmlElement(nillable = false, name = "portfolio")
    private Portfolio portfolio;

	// no XmlElement or XmlAttribute
	private Distribution projectCategoryDistribution;

    public Double getAvailability() {
        return availability;
    }

    public void setAvailability(Double availability) {
        this.availability = availability;
    }

    public Long getIterations() {
        return iterations;
    }

    public Long getPause() {
        return pause;
    }

    public Long getPlanningHorizont() {
        return planningHorizont;
    }

    public void setIterations(Long iterations) {
        this.iterations = iterations;
    }

    public List<Team> getTeams() {
        if (teams == null) {
            teams = new ArrayList<Team>();
        }
        return this.teams;
    }

    public List<Skill> getSkillPool() {
        if (skillPool == null) {
            skillPool = new ArrayList<Skill>();
        }
        return this.skillPool;
    }

    public Skill getSkillFromPool(String ref) {
        Skill skill = null;
        for (Skill s : skillPool) {
            if (ref.equals(s.getId())) {
                skill = s;
                break;
            }
        }
        return skill;
    }

    public List<Category> getProjectCategoryPool() {
        return projectCategoryPool;
    }

    public Category getProjectCategoryFromPool(String ref) {
        Category category = null;
        for (Category s : projectCategoryPool) {
            if (ref.equals(s.getId())) {
                category = s;
                break;
            }
        }
        return category;
    }

	public Distribution getProjectCategoryDistribution() {
		return projectCategoryDistribution;
	}

    public List<Phase> getPhases() {
        return phasePool;
    }

    public Phase getPhaseFromPool(String ref) {
        Phase phase = null;
        for (Phase s : phasePool) {
            if (ref.equals(s.getId())) {
                phase = s;
                break;
            }
        }
        return phase;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    @Override
    public String toString() {
        return "Simulation [availability=" + availability + ", iterations=" + iterations + ", pause=" + pause + ", planningHorizont=" + planningHorizont
                + ", skillPool=" + skillPool + ", projectCategories=" + projectCategories + ", phasePool=" + phasePool + ", teams=" + teams + ", portfolio="
                + portfolio + "]";
    }

}
