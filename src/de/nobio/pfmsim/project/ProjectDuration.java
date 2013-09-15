package de.nobio.pfmsim.project;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import de.nobio.pfmsim.distribution.Distribution;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "project_duration")
public class ProjectDuration {

    @XmlElement(name = "distribution", required = true)
    private Distribution duration;

    public Distribution getDuration() {
        return duration;
    }

    public void setDuration(Distribution duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "ProjectDuration [duration=" + duration + "]";
    }

}
