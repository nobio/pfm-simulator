package de.nobio.pfmsim.project;

import de.nobio.pfmsim.resource.Skill;

public class Task {

    private Skill skill;
    private Workload workload;

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public Workload getWorkload() {
        return workload;
    }

    public void setWorkload(Workload workload) {
        this.workload = workload;
    }

}
