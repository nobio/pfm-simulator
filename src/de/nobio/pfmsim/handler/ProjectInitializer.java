/**
 * 
 */
package de.nobio.pfmsim.handler;

import de.nobio.pfmsim.Util;
import de.nobio.pfmsim.project.Category;
import de.nobio.pfmsim.project.Portfolio;
import de.nobio.pfmsim.runtime.PFMContext;
import de.nobio.pfmsim.runtime.Simulation;

/**
 * @author cs6518
 *
 */
public class ProjectInitializer implements Handler {

    /**
     * @see de.nobio.pfmsim.handler.Handler#handle(de.nobio.pfmsim.runtime.PFMContext)
     */
    @Override
    public void handle(PFMContext context) {
        Util.log(this.getClass().getName());
        
        Simulation config = context.getConfiguration();
        Portfolio portfolio = config.getPortfolio();
        
        // can we start a project?
        if(portfolio.getProjectStartDistribution().getRandomNumericValue() > 50) {
            Util.log("Ohhh a project. Let's start it!!");
            
            // which project category should the project have?
            Category projectCategory = config.getProjectCategoryFromPool(config.getProjectCategoryDistribution().getRandomWeightedValue());
            Util.log(projectCategory);
            Util.log("let's setup a " + projectCategory.getName() + " project");
        }
    }

}
