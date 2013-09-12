package de.nobio.pfmsim.project;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import de.nobio.pfmsim.distribution.Distribution;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "workload", propOrder = { "distribution" })
public class Workload {

    @XmlElement(name = "distribution", required = true)
    private Distribution distribution;

    public Distribution getDistribution() {
        return distribution;
    }

    @Override
    public String toString() {
        return "Workload [distribution=" + distribution + "]";
    }

}