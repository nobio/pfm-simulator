package de.nobio.pfmsim.resource;

import java.util.ArrayList;

public class Plan extends ArrayList<PlanItem> {

    private static final long serialVersionUID = 602530673196696823L;
    private Double baseAvailability;
    private static final int PLANNING_HORIZONT = 2 * 365;

    public Plan(Double baseAvailability) {
        super(PLANNING_HORIZONT);
        this.baseAvailability = baseAvailability;

    }

    public Long getFreeCapacity() {
        double freeCapacity = baseAvailability * PLANNING_HORIZONT;
        for (PlanItem item : this) {
            freeCapacity -= item.getAllocation();
        }
        return (long)freeCapacity;
    }
    
    public PlanItem getFirst() {
        PlanItem pi = null;
        
        if(size() > 0) {
            pi=get(0);
        }
        return pi;
    }
}
