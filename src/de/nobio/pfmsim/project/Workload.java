package de.nobio.pfmsim.project;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "workload", propOrder = { "distribution" })
public class Workload {

    @XmlElement(name = "distribution", nillable = true, required = true)
    private List<Distribution> distribution;

    public List<Distribution> getDistribution() {
        return distribution;
    }

    @Override
    public String toString() {
        return "Workload [distribution=" + distribution + "]";
    }

}