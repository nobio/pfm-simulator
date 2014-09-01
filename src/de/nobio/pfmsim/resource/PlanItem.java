package de.nobio.pfmsim.resource;

import de.nobio.pfmsim.project.Phase;

/**
 */
public class PlanItem {

    private Double allocation;
    private Phase linkToPhase;

    public PlanItem() {
        super();
        this.linkToPhase = null;
        this.allocation = 0D;
    }

    /**
    
     * @return the allocation */
    public Double getAllocation() {
        return allocation;
    }

    /**
     * @param allocation
     *            the allocation to set
     */
    public void setAllocation(Double allocation) {
        this.allocation = allocation;
    }

    /**
    
     * @return the linkToPhase */
    public Phase getLinkToPhase() {
        return linkToPhase;
    }

    /**
     * @param linkToPhase
     *            the linkToPhase to set
     */
    public void setLinkToPhase(Phase linkToPhase) {
        this.linkToPhase = linkToPhase;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "PlanItem [allocation=" + allocation + ", linkToProject=" + linkToPhase.getLinktoProject().hashCode() + ", linkToPhase=" + linkToPhase + "]";
    }

}
