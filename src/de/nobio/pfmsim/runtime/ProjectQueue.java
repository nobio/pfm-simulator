package de.nobio.pfmsim.runtime;

import java.util.PriorityQueue;

import de.nobio.pfmsim.project.Project;

/**
 */
public class ProjectQueue extends PriorityQueue<Project> {

    private static final long serialVersionUID = 7167246496321447222L;
    private long sum = 0;

    /**
     * Method addTimeEvent.
     * 
     * @param amount
     *            long
     * @return Double
     */
    public Double addTimeEvent(long amount) {
        sum += amount;

        return (double) sum;
    }

    /**
     * Method getAvg.
     * 
     * @return Double
     */
    public Double getAvg() {
        return 0D;
    }

    /**
     * Method getDuration.
     * 
     * @return Double
     */
    public Double getDuration() {
        return (double) sum;
    }

    /**
     * Method getTotalWorkload.
     * 
     * @return Long
     */
    public Long getTotalWorkload() {
        Long sumWorkload = 0L;
        for (Project project : this) {
            sumWorkload += project.getTotalWorkload();
        }
        return sumWorkload;
    }
}
