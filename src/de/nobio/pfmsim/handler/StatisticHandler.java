package de.nobio.pfmsim.handler;

import java.util.logging.Logger;

import de.nobio.pfmsim.runtime.PFMContext;

public class StatisticHandler implements Handler {

    private static final Logger LOGGER = Logger.getLogger(StatisticHandler.class.getName());

    @Override
    public void handle(PFMContext context) {
        String msg = "\nWaiting Project:  " + context.getWaitingProjects().size() + " with total workload " + context.getWaitingProjects().getTotalWorkload();
        msg += "\nRunning Projects: " + context.getRunningProjects().size() + " with total workload " + context.getRunningProjects().getTotalWorkload();
        msg += "\nTeams:            " + context.getConfiguration().getTeams().size() + "; capacity: " + context.getConfiguration().getTotalCapacity() + "; thereof idle: (to be calculated...)" ;
        
        LOGGER.info("\n********************************************************************");
        LOGGER.info(msg);
        LOGGER.info("\n********************************************************************");
    }

}
