package de.nobio.pfmsim.handler;

import de.nobio.pfmsim.Util;
import de.nobio.pfmsim.runtime.PFMContext;

public class ResourceContributionHandler implements Handler {

    @Override
    public void handle(PFMContext context) {
        Util.log(this.getClass().getName());
    }

}
