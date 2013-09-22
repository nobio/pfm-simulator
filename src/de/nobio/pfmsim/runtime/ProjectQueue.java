package de.nobio.pfmsim.runtime;

import java.util.PriorityQueue;

import de.nobio.pfmsim.project.Project;

public class ProjectQueue extends PriorityQueue<Project> {

    private static final long serialVersionUID = 7167246496321447222L;

    public Long getTotalWorkload() {
        Long sumWorkload = 0L;
        for (Project project : this) {
            sumWorkload += project.getTotalWorkload();
        }
        return sumWorkload;
    }

}
