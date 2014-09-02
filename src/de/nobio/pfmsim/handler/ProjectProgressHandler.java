package de.nobio.pfmsim.handler;

import de.nobio.pfmsim.project.Project;
import de.nobio.pfmsim.project.Project.ProjectStatus;
import de.nobio.pfmsim.runtime.PFMContext;

public class ProjectProgressHandler implements Handler {

    @Override
    public void handle(PFMContext context) {
        for (Project project : context.getRunningProjects()) {

            if (project.getStatus() == Project.ProjectStatus.Running) {
                project.setRunDuration(project.getRunDuration() + 1);
            } else if (project.getStatus() == ProjectStatus.Allocated || project.getStatus() == ProjectStatus.Waiting) {
                project.setIdleDuration(project.getIdleDuration() + 1);
            }

        }
    }

}
