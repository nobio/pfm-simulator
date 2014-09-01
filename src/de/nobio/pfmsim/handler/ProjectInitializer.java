/**
 * 
 */
package de.nobio.pfmsim.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import de.nobio.pfmsim.project.Category;
import de.nobio.pfmsim.project.Phase;
import de.nobio.pfmsim.project.Portfolio;
import de.nobio.pfmsim.project.Project;
import de.nobio.pfmsim.project.Workload;
import de.nobio.pfmsim.resource.Resource;
import de.nobio.pfmsim.resource.Skill;
import de.nobio.pfmsim.runtime.PFMContext;
import de.nobio.pfmsim.runtime.Simulation;

/**
 * @author cs6518
 * @version $Revision: 1.0 $
 */
public class ProjectInitializer implements Handler {

    private static final Logger LOGGER = Logger.getLogger(ProjectInitializer.class.getName());

    /**
     * @see de.nobio.pfmsim.handler.Handler#handle(de.nobio.pfmsim.runtime.PFMContext)
     */
    @Override
    public void handle(PFMContext context) throws Exception {
        LOGGER.info(this.getClass().getName());

        Simulation config = context.getConfiguration();
        Portfolio portfolio = config.getPortfolio();

        // can we start a project?
        if (portfolio.getProjectCategoryStartProbability().getRandomNumericValue() > 50) {
            Project project = new Project();

            LOGGER.info("Ohhh a project. Let's start it!! (" + project.hashCode() + ")");

            // which project category should the project have?
            Category category = config.getProjectCategoryFromPool(config.getProjectCategoryDistribution().getRandomeValue());
            LOGGER.info("Project " + project.hashCode() + " let's setup a " + category.getName() + " project");

            project.setCategory(category);
            project.setPriority((long) Math.random() * 100);
            Long estimatedDuration = Math.round(category.getProjectDuration().getDuration().getRandomNumericValue());
            project.setDuration(estimatedDuration);

            // calculate the needed resources (skills)
            for (Skill skill : category.getNeededSkills()) {
                Long rnd = Math.round(Double.valueOf(skill.getDistribution().getDistribution().getRandomeValue().toString()));
                if (rnd < 0) {
                    rnd = 0L;
                }

                // init rnd resources and add them to the project
                for (int n = 0; n < rnd; n++) {
                    Resource res = new Resource();
                    res.addSkill(skill);
                    res.setBaseAvailability(config.getAvailability() * config.getPlanningHorizont());

                    project.addNeededResource(res);
                }
                LOGGER.info("Project " + project.hashCode() + " Needed skill: " + skill.getName() + " from " + rnd + " resources");
            }

            // distribute the expected workload amongst the phases
            List<Phase> projectPhases = new ArrayList<Phase>();
            Double sumOfWeights = 0.0D;
            for (Phase phase : category.getPhases()) {
                Double phaseWeight = phase.calculateWorkload();
                sumOfWeights += phaseWeight;
            }

            for (Phase phase : category.getPhases()) {
                Workload workload = new Workload();
                workload.setWorkload((long) (project.getDuration() * phase.getWorkload().getWorkloadWeight() / sumOfWeights));
                Phase projectPhase = (Phase) phase.clone();

                projectPhase.setWorkload(workload);
                projectPhases.add(projectPhase);
                LOGGER.info("Project " + project.hashCode() + " Workload of phase " + projectPhase.getName() + ": " + projectPhase.getWorkload().getWorkload());
            }
            project.setPhases(projectPhases);
            project.setDuration(project.getTotalWorkload());
            context.getWaitingProjects().add(project);
            LOGGER.info("Workload of this project (" + project.hashCode() + "): " + project.getTotalWorkload() + " in " + project.getPhases().size()
                    + " project phases distributed over " + project.getNeededResources().size() + " resources (" + project.getTotalWorkload() / project.getNeededResources().size()
                    + " each)");
        }
    }
}
