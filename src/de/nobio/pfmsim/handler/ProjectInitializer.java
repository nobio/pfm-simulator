/**
 * 
 */
package de.nobio.pfmsim.handler;

import java.util.logging.Logger;

import de.nobio.pfmsim.project.Category;
import de.nobio.pfmsim.project.Portfolio;
import de.nobio.pfmsim.project.Project;
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
    public void handle(PFMContext context) {
        LOGGER.info(this.getClass().getName());

        Simulation config = context.getConfiguration();
        Portfolio portfolio = config.getPortfolio();

        // can we start a project?
        if (portfolio.getProjectCategoryStartProbability().getRandomNumericValue() > 50) {
            LOGGER.info("Ohhh a project. Let's start it!!");

            // which project category should the project have?
            Category projectCategory = config.getProjectCategoryFromPool(config.getProjectCategoryDistribution().getRandomeValue());
            LOGGER.info("let's setup a " + projectCategory.getName() + " project");

            Project project = new Project();
            project.setCategory(projectCategory);
            project.setPriority((long) Math.random() * 100);

            // calculate the needed resources (skills)
            for (Skill skill : projectCategory.getNeededSkills()) {
                Long rnd = Math.round(Double.valueOf(skill.getDistribution().getDistribution().getRandomeValue().toString()));
                System.out.println(skill.getName() + " " + rnd);

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
        }
    }

}
