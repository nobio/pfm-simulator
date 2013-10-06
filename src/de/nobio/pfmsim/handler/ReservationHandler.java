/**
 * 
 */
package de.nobio.pfmsim.handler;

import java.util.logging.Logger;

import de.nobio.pfmsim.project.Phase;
import de.nobio.pfmsim.project.Project;
import de.nobio.pfmsim.project.Project.ProjectStatus;
import de.nobio.pfmsim.resource.Period;
import de.nobio.pfmsim.resource.Resource;
import de.nobio.pfmsim.resource.Skill;
import de.nobio.pfmsim.runtime.PFMContext;
import de.nobio.pfmsim.runtime.Simulation;

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
        Simulation config = context.getConfiguration();

        Long workload;

        for (Project project : context.getWaitingProjects()) {

            if (project.getStatus() == ProjectStatus.Waiting) {

                Period phasePeriod = null;

                for (Phase phase : project.getPhases()) {
                    workload = phase.getWorkload().getWorkload();

                    if (phasePeriod != null) {
                        phasePeriod.setBegin(phasePeriod.getEnd());
                        phasePeriod.setEnd((int) (phasePeriod.getEnd() + phase.getWorkload().getWorkload()));
                    }

                    // LOGGER.info("phase " + phase.getName() + " has workload "
                    // +
                    // phase.getWorkload().getWorkload());
                    // do we have resources with the right skills
                    for (Resource resource : project.getNeededResources()) {

                        // there should only be one skill in this list
                        Skill neededSkill = resource.getSkills().get(0);

                        LOGGER.info("Phase " + phase.getName() + "; need a resource with skill " + neededSkill.getName() + " and min. availibility of " + workload
                                + " and in the period " + phasePeriod);

                        Resource foundResource = config.getResourceWithSkill(neededSkill, phasePeriod, workload);

                        if (foundResource != null) {

                            Period period = foundResource.allocate(project, phase, phasePeriod, workload);
                            if (period != null && period.isValid()) {
                                LOGGER.info("Found: " + foundResource.getId() + " and could allocate: " + period);
                                phasePeriod = period;
                                phasePeriod.setEnd((int) ((period.getEnd() + 1) * 1.3));
                            } else {
                                LOGGER.info("Unable to allocate this resource " + foundResource.getId() + "(" + period + ")");
                            }

                        } else {
                            LOGGER.info("No available resources found!");
                        }
                    }
                }

                // project could be started => set the status of this project
                if (project.isAllocated()) {
                    project.setStatus(ProjectStatus.Allocated);
                }
            }
        }
    }
}
