package de.nobio.pfmsim.project;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import de.nobio.pfmsim.distribution.Distribution;

/**
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "workload", propOrder = { "distribution" })
public class Workload {

    @XmlTransient
    private Long workload;

    @XmlTransient
    private Double workloadWeight;

    @XmlElement(name = "distribution", required = true)
    private Distribution distribution;

    /**
     * Method getDistribution.
     * 
     * @return Distribution
     */
    public Distribution getDistribution() {
        return distribution;
    }

    /**
     * Method getWorkload.
     * 
     * @return Long
     */
    public Long getWorkload() {
        return workload;
    }

    /**
     * Method getWorkloadWeight.
     * 
     * @return Double
     */
    public Double getWorkloadWeight() {
        return workloadWeight;
    }

    /**
     * Method setWorkload.
     * 
     * @param workload
     *            Long
     */
    public void setWorkload(Long workload) {
        this.workload = workload;
    }

    /**
     * Method setWorkloadWeight.
     * 
     * @param workloadWeight
     *            Double
     */
    public void setWorkloadWeight(Double workloadWeight) {
        this.workloadWeight = workloadWeight;
    }

    /**
     * Method toString.
     * 
     * @return String
     */
    @Override
    public String toString() {
        return "Workload [workload=" + workload + ", distribution=" + distribution + "]";
    }

}