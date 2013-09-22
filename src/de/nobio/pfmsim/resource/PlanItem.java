package de.nobio.pfmsim.resource;

import de.nobio.pfmsim.project.Phase;

public class PlanItem {

    private Phase linkToPhase;
    private Double allocation;

    public Phase getLinkToPhase() {
        return linkToPhase;
    }

    public void setLinkToPhase(Phase linkToPhase) {
        this.linkToPhase = linkToPhase;
    }

    public Double getAllocation() {
        return allocation;
    }

    public void setAllocation(Double allocation) {
        this.allocation = allocation;
    }

}
