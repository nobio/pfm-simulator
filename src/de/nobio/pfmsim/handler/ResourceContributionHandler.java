package de.nobio.pfmsim.handler;

import java.util.List;
import java.util.logging.Logger;

import de.nobio.pfmsim.resource.Resource;
import de.nobio.pfmsim.runtime.PFMContext;

public class ResourceContributionHandler implements Handler {

    private static final Logger LOGGER = Logger.getLogger(ResourceContributionHandler.class.getName());

    @Override
    public void handle(PFMContext context) {
        List<Resource> resources = context.getConfiguration().getAllResources();
        for (Resource resource : resources) {
            LOGGER.info(resource.getId() + " " + resource.getSkills().get(0).getId() + " " + resource.getAllocation());
            resource.contribute();
            LOGGER.info(resource.getId() + " " + resource.getSkills().get(0).getId() + " " + resource.getAllocation());
        }
    }

}
