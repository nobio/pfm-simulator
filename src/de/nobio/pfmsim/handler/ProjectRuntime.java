/**
 * 
 */
package de.nobio.pfmsim.handler;

import de.nobio.pfmsim.project.Project;
import de.nobio.pfmsim.runtime.PFMContext;

/**
 * @author cs6518
 * 
 * @version $Revision: 1.0 $
 */
public class ProjectRuntime implements Handler {

    /**
     * @see de.nobio.pfmsim.handler.Handler#handle(de.nobio.pfmsim.runtime.PFMContext)
     */
    @Override
    public void handle(PFMContext context) {

        for (Project project : context.getWaitingProjects()) {
            project.setIdleDuration(project.getIdleDuration() + 1);
            context.getWaitingProjects().addTimeEvent(1);
        }

        for (Project project : context.getRunningProjects()) {
            project.setRunDuration(project.getRunDuration() + 1);
            context.getRunningProjects().addTimeEvent(1);
        }

    }

}
