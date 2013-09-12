package de.nobio.pfmsim.handler;

import java.util.logging.Logger;

import de.nobio.pfmsim.runtime.PFMContext;

public class ResourceContributionHandler implements Handler {

    private static final Logger LOGGER = Logger.getLogger(ResourceContributionHandler.class.getName());

    @Override
    public void handle(PFMContext context) {
        LOGGER.info(this.getClass().getName());
    }

}
