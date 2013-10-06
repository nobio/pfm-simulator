/**
 * 
 */
package de.nobio.pfmsim.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import de.nobio.pfmsim.project.Project;
import de.nobio.pfmsim.project.Project.ProjectStatus;
import de.nobio.pfmsim.runtime.PFMContext;

/**
 * @author cs6518
 * 
 */
public class ProjectStarter implements Handler {

    private static final Logger LOGGER = Logger.getLogger(ProjectStarter.class.getName());

    /**
     * @see de.nobio.pfmsim.handler.Handler#handle(de.nobio.pfmsim.runtime.PFMContext)
     */
    @Override
    public void handle(PFMContext context) {
        
        List<Project> toBeRemoved = new ArrayList<Project>();
        
        for (Project project : context.getWaitingProjects()) {
            
            if (project.getStatus() == ProjectStatus.Allocated) {
                toBeRemoved.add(project);
                project.setStatus(ProjectStatus.Running);
                context.getRunningProjects().add(project);
                LOGGER.info("started project " + project.hashCode());
            }
        }
        
        context.getWaitingProjects().removeAll(toBeRemoved);

    }

}
