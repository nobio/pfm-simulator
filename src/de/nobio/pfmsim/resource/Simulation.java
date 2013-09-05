//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB)
// Reference Implementation, vJAXB 2.1.10 in JDK 6
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source
// schema.
// Generated on: 2013.09.01 at 02:14:43 PM MESZ
//

package de.nobio.pfmsim.resource;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "simulation")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "simulation", propOrder = { "availability", "iterations", "skillPool", "team" })
public class Simulation {

    @XmlElement(required = true)
    private Double availability;
    @XmlElement(required = true)
    private Long iterations;
    @XmlElement(nillable = true, name = "skill")
    private List<Skill> skillPool;
    @XmlElement(nillable = true)
    private List<Team> team;

    public Double getAvailability() {
        return availability;
    }

    public void setAvailability(Double availability) {
        this.availability = availability;
    }

    public Long getIterations() {
        return iterations;
    }

    public void setIterations(Long iterations) {
        this.iterations = iterations;
    }

    public List<Team> getTeams() {
        if (team == null) {
            team = new ArrayList<Team>();
        }
        return this.team;
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

    @Override
    public String toString() {
        return "Simulation [\navailability=" + availability + ", \niterations=" + iterations + ", \nskillPool=" + skillPool + ", \nteam=" + team + "]";
    }

}
