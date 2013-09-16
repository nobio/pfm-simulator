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
            LOGGER.info("Ohhh a project. Let's start it!!");

            // which project category should the project have?
            Category category = config.getProjectCategoryFromPool(config.getProjectCategoryDistribution().getRandomeValue());
            LOGGER.info("let's setup a " + category.getName() + " project");

            Project project = new Project();

            project.setCategory(category);
            project.setPriority((long) Math.random() * 100);
            Long estimatedDuration = Math.round(category.getProjectDuration().getDuration().getRandomNumericValue());
            project.setDuration(estimatedDuration);

            // distribute the expected workload amongst the phases
            List<Phase> projectPhases = new ArrayList<Phase>();
            Double sumOfWeights = 0.0D;
            for (Phase phase : category.getPhases()) {
                Double phaseWeight = phase.getWorkload().getDistribution().getRandomNumericValue();
                phase.getWorkload().setWorkloadWeight(phaseWeight);
                sumOfWeights += phaseWeight;
            }
            for (Phase phase : category.getPhases()) {
                Workload workload = new Workload();
                workload.setWorkload((long) (project.getDuration() * phase.getWorkload().getWorkloadWeight() / sumOfWeights));
                Phase projectPhase = (Phase) phase.clone();
                projectPhase.setWorkload(workload);
                projectPhases.add(projectPhase);
            }
            project.setPhases(projectPhases);

            LOGGER.info(project.getDuration() + " vs. " + project.getTotalWorkload());

            // calculate the needed resources (skills)
            for (Skill skill : category.getNeededSkills()) {
                Long rnd = Math.round(Double.valueOf(skill.getDistribution().getDistribution().getRandomeValue().toString()));
                if (rnd < 0) {
                    rnd = 0L;
                }
                LOGGER.info(skill.getName() + " " + rnd);

                // init rnd resources and add them to the project
                for (int n = 0; n < rnd; n++) {
                    Resource res = new Resource();
                    res.addSkill(skill);
                    res.setAvailability(config.getAvailability() * config.getPlanningHorizont());
                    res.setReserved(0.0);

                    project.addResource(res);
                }
            }

            context.getWaitingProjects().add(project);
            LOGGER.info(project.getCategory().getName());
        }
    }

}
