package de.nobio.pfmsim.project;

import de.nobio.pfmsim.resource.Skill;

/**
 */
public class Task {

    private Skill skill;
    private Workload workload;

    /**
     * Method getSkill.
     * @return Skill
     */
    public Skill getSkill() {
        return skill;
    }

    /**
     * Method setSkill.
     * @param skill Skill
     */
    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    /**
     * Method getWorkload.
     * @return Workload
     */
    public Workload getWorkload() {
        return workload;
    }

    /**
     * Method setWorkload.
     * @param workload Workload
     */
    public void setWorkload(Workload workload) {
        this.workload = workload;
    }

}
