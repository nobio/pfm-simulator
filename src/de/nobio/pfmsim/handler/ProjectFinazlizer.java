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
 * @version $Revision: 1.0 $
 */
public class ProjectFinazlizer implements Handler {

    private static final Logger LOGGER = Logger.getLogger(ProjectFinazlizer.class.getName());

    /**
     * @see de.nobio.pfmsim.handler.Handler#handle(de.nobio.pfmsim.runtime.PFMContext)
     */
    @Override
    public void handle(PFMContext context) {
        for (Project project : context.getRunningProjects()) {
            LOGGER.info("Project: " + project.hashCode() + "; ALLOC: " + project.getTotalAllocation() + " Workload: " + project.getTotalWorkload());

            // less then 10% of a project means: Project's finished
            if (project.getTotalAllocation() <= project.getTotalWorkload() / 10) {
                LOGGER.info("finalize project " + project.hashCode());
                project.setStatus(ProjectStatus.Finished);
            }
        }
    }

}
