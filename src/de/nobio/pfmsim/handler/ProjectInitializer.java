/**
 * 
 */
package de.nobio.pfmsim.handler;

import java.util.logging.Logger;

import de.nobio.pfmsim.project.Category;
import de.nobio.pfmsim.project.Portfolio;
import de.nobio.pfmsim.runtime.PFMContext;
import de.nobio.pfmsim.runtime.Simulation;

/**
 * @author cs6518
 *
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
        if (portfolio.getProjectStartDistribution().getRandomNumericValue() > 50) {
            LOGGER.info("Ohhh a project. Let's start it!!");

            // which project category should the project have?
            Category projectCategory = config.getProjectCategoryFromPool(config.getProjectCategoryDistribution().getRandomWeightedValue());
            LOGGER.info(projectCategory.toString());
            LOGGER.info("let's setup a " + projectCategory.getName() + " project");
        }
    }

}
