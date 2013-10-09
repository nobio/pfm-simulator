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
public class ProjectCompleter implements Handler {

    private static final Logger LOGGER = Logger.getLogger(ProjectCompleter.class.getName());

    /**
     * @see de.nobio.pfmsim.handler.Handler#handle(de.nobio.pfmsim.runtime.PFMContext)
     */
    @Override
    public void handle(PFMContext context) {

        List<Project> toBeRemoved = new ArrayList<Project>();

        for (Project project : context.getRunningProjects()) {

            if (project.getStatus() == ProjectStatus.Finished) {
                toBeRemoved.add(project);
                LOGGER.info("removed project " + project.hashCode());
            }
        }

        context.getRunningProjects().removeAll(toBeRemoved);

    }

}
