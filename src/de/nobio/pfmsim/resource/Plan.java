package de.nobio.pfmsim.resource;

import java.util.ArrayList;

import de.nobio.pfmsim.Util;
import de.nobio.pfmsim.project.Phase;
import de.nobio.pfmsim.project.Project;

/**
 */
public class Plan extends ArrayList<PlanItem> {

    private static final long serialVersionUID = 602530673196696823L;
    private static final int PLANNING_HORIZONT = 2 * 365; // 2 years

    private Double baseAvailability;

    /**
     * Constructor for Plan.
     * 
     * @param baseAvailability
     *            Double
     */
    public Plan(Double baseAvailability) {
        super(PLANNING_HORIZONT);
        this.baseAvailability = baseAvailability / PLANNING_HORIZONT;
        for (int n = 0; n < PLANNING_HORIZONT; n++) {
            add(new PlanItem());
        }
    }

    /**
     * allocates the workload calculated to PlanItems; the workload might be
     * greater than one PlanItem's duration; the next free time slot that is not
     * disrupted will be taken
     * 
     * @param phase
     *            The phase this allocation is linked to
     * @param workload
     *            the total workload an allocation should be done
     * 
     * 
     * @param project
     *            Project
     * @param phasePeriod
     *            Period
     * @return true when the allocation could be done
     */
    public Period allocate(Project project, Phase phase, Period phasePeriod, Long workload) {

        if (workload == 0) {
            return phasePeriod;
        }

        if (phasePeriod != null) {
            // correct end of period to max planning horizont
            if (phasePeriod.getEnd() > PLANNING_HORIZONT - 1) {
                phasePeriod.setEnd(PLANNING_HORIZONT - 1);
            }
        }

        PlanItem pi = null;
        PlanItem pi2 = null;
        Double timeslot = 0D;
        int beginSearch = (phasePeriod == null ? 0 : phasePeriod.getBegin());
        int endSearch = (phasePeriod == null ? this.size() : phasePeriod.getEnd());
        int startIdx = 0;
        int stopIdx = 0;

        // let's search a time slot...
        for (startIdx = beginSearch; startIdx <= endSearch && timeslot < workload; startIdx++) {

            pi = this.get(startIdx);

            if (pi.getAllocation() == 0) {
                pi2 = this.get(startIdx);
                // n is not the starting point; let's look for a not disrupted
                // time slot
                for (stopIdx = startIdx; stopIdx <= endSearch && pi2.getAllocation() == 0 && timeslot < workload; stopIdx++) {
                    timeslot += this.baseAvailability;
                    pi2 = this.get(stopIdx);
                }

            }
        }

        if (startIdx == endSearch && workload > 1) {
            return null;
        }

        // we have found a time slot: n to i
        // let's allocate the this plan to this project, phase and period
        for (int n = startIdx - 1; n < stopIdx; n++) {
            project.increaseAllocation(this.baseAvailability);
            this.get(n).setAllocation(this.baseAvailability);
            this.get(n).setLinkToPhase(phase);
        }

        return new Period(startIdx - 1, stopIdx - 1);
    }

    /**
     * Method contribute.
     * 
     * @return Double
     */
    public Double contribute() {
        Double contribution = 0D;
        PlanItem planitem = getFirst();

        if (planitem.getLinkToPhase() != null) {
            // contribution is around the allocation
            // contribution =
            // Util.getNormallyDistributedRandomNumer(planitem.getAllocation(),
            // planitem.getAllocation() * 0.2);
            contribution = Util.getEquallyDistributedRandomNumer(planitem.getAllocation() * 0.8, planitem.getAllocation() * 1.1);

            Project project = planitem.getLinkToPhase().getLinktoProject();
            project.decreaseAllocation(contribution);

            // shift all planitems one forth
            remove(0); // remove the first
            add(new PlanItem()); // add an empty item at the end
        }
        return contribution;
    }

    /**
     * Method getAllocation.
     * 
     * @return Double
     */
    public Double getAllocation() {
        double allocation = 0D;
        for (PlanItem item : this) {
            allocation += item.getAllocation();
        }
        return allocation;

    }

    /**
     * Method getAllocation.
     * 
     * @param period
     *            Period
     * @return Double
     */
    public Double getAllocation(Period period) {
        double allocation = 0D;
        int end = period.getEnd() > PLANNING_HORIZONT ? PLANNING_HORIZONT : period.getEnd();
        for (int n = period.getBegin(); n < end; n++) {
            allocation += this.get(n).getAllocation();
        }
        return allocation;

    }

    /**
     * Method getFirst.
     * 
     * @return PlanItem
     */
    public PlanItem getFirst() {
        PlanItem pi = null;

        if (size() > 0) {
            pi = get(0);
        }
        return pi;
    }

    /**
     * Method getFreeCapacity.
     * 
     * @return Double
     */
    public Double getFreeCapacity() {
        return baseAvailability * PLANNING_HORIZONT - getAllocation();
    }

    /**
     * Method getFreeCapacity.
     * 
     * @param period
     *            Period
     * @return Double
     */
    public Double getFreeCapacity(Period period) {
        Double allocation;

        if (period == null) {
            allocation = baseAvailability * PLANNING_HORIZONT - getAllocation();
        } else {
            allocation = baseAvailability * (period.getEnd() - period.getBegin()) - getAllocation(period);
        }

        return allocation;
    }
}
