package de.nobio.pfmsim.resource;

import java.util.ArrayList;

import de.nobio.pfmsim.project.Phase;

public class Plan extends ArrayList<PlanItem> {

    private static final long serialVersionUID = 602530673196696823L;
    // private static final Logger LOGGER =
    // Logger.getLogger(Plan.class.getName());
    private Double baseAvailability;
    private static final int PLANNING_HORIZONT = 2 * 365; // 2 years

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
     * @return true when the allocation could be done
     */
    public Period allocate(Phase phase, Period phasePeriod, Long workload) {

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

        // we have found a time slot: n to i
        for (int n = startIdx - 1; n < stopIdx; n++) {
            this.get(n).setAllocation(this.baseAvailability);
            this.get(n).setLinkToPhase(phase);
        }

        if (startIdx == endSearch) {
            return null;
        } else {
            return new Period(startIdx - 1, stopIdx - 1);
        }
    }

    public Double getFreeCapacity() {
        return baseAvailability * PLANNING_HORIZONT - getAllocation();
    }

    public Double getFreeCapacity(Period period) {
        Double allocation;

        if (period == null) {
            allocation = baseAvailability * PLANNING_HORIZONT - getAllocation();
        } else {
            allocation = baseAvailability * (period.getEnd() - period.getBegin()) - getAllocation(period);
        }

        return allocation;
    }

    public Double getAllocation() {
        double allocation = 0D;
        for (PlanItem item : this) {
            allocation += item.getAllocation();
        }
        return allocation;

    }

    public Double getAllocation(Period period) {
        double allocation = 0D;
        int end = period.getEnd() > PLANNING_HORIZONT ? PLANNING_HORIZONT : period.getEnd();
        for (int n = period.getBegin(); n < end; n++) {
            allocation += this.get(n).getAllocation();
        }
        return allocation;

    }

    public PlanItem getFirst() {
        PlanItem pi = null;

        if (size() > 0) {
            pi = get(0);
        }
        return pi;
    }
}
