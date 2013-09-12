/**
 * 
 */
package de.nobio.pfmsim.handler;

import java.util.logging.Logger;

import de.nobio.pfmsim.runtime.PFMContext;

/**
 * @author cs6518
 *
 */
public class ProjectStarter implements Handler {

    private static final Logger LOGGER = Logger.getLogger(ProjectStarter.class.getName());

    /**
     * @see de.nobio.pfmsim.handler.Handler#handle(de.nobio.pfmsim.runtime.PFMContext)
     */
    @Override
    public void handle(PFMContext context) {
        LOGGER.info(this.getClass().getName());
    }

}
