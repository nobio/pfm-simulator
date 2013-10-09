/**
 * 
 */
package de.nobio.pfmsim.handler;

import java.util.logging.Logger;

import de.nobio.pfmsim.project.Project;
import de.nobio.pfmsim.project.Project.ProjectStatus;
import de.nobio.pfmsim.runtime.PFMContext;

/**
 * @author cs6518
 * 
 */
public class ProjectFinazlizer implements Handler {

    private static final Logger LOGGER = Logger.getLogger(ProjectFinazlizer.class.getName());

    /**
     * @see de.nobio.pfmsim.handler.Handler#handle(de.nobio.pfmsim.runtime.PFMContext)
     */
    @Override
    public void handle(PFMContext context) {
        for (Project project : context.getRunningProjects()) {

            if (project.getTotalAllocation() <= 210) {
                LOGGER.info("finalize project " + project.hashCode());
                project.setStatus(ProjectStatus.Finished);
            }
        }
    }

}
