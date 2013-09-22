/**
 * 
 */
package de.nobio.pfmsim.handler;

import java.util.logging.Logger;

import de.nobio.pfmsim.project.Project;
import de.nobio.pfmsim.resource.Resource;
import de.nobio.pfmsim.resource.Skill;
import de.nobio.pfmsim.runtime.PFMContext;

/**
 * @author cs6518
 * 
 */
public class ReservationHandler implements Handler {

    private static final Logger LOGGER = Logger.getLogger(ReservationHandler.class.getName());

    /**
     * @see de.nobio.pfmsim.handler.Handler#handle(de.nobio.pfmsim.runtime.PFMContext)
     */
    @Override
    public void handle(PFMContext context) {
        for (Project project : context.getWaitingProjects()) {
            // do we have resources with the right skills
            for (Resource resource : project.getNeededResources()) {
                // there should only be one skill in this list
                Skill neededSkill = resource.getSkills().get(0);
                LOGGER.info("Need a resource with skill " + neededSkill.getName() + " and min. availibility of " + project.getDuration());
                Resource foundResource = context.getConfiguration().getResourceWithSkill(neededSkill, project.getDuration());
                LOGGER.info("Found one: " + foundResource);
                // project.getPhases().get(0).getWorkload().getWorkload()).toString());
            }
        }
    }

}
