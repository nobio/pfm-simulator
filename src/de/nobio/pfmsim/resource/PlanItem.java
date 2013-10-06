package de.nobio.pfmsim.resource;

import de.nobio.pfmsim.project.Phase;
import de.nobio.pfmsim.project.Project;

public class PlanItem {

    private Double allocation;
    private Phase linkToPhase;
    private Project linkToProject;

    public PlanItem() {
        super();
        this.linkToPhase = null;
        this.linkToProject = null;
        this.allocation = 0D;
    }

    /**
     * @return the allocation
     */
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
     * @return the linkToPhase
     */
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
     * @return the linkToProject
     */
    public Project getLinkToProject() {
        return linkToProject;
    }

    /**
     * @param linkToProject
     *            the linkToProject to set
     */
    public void setLinkToProject(Project linkToProject) {
        this.linkToProject = linkToProject;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "PlanItem [allocation=" + allocation + ", linkToProject=" + linkToProject.hashCode() + ", linkToPhase=" + linkToPhase + "]";
    }

}
