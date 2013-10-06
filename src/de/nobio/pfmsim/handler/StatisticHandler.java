package de.nobio.pfmsim.handler;

import java.util.logging.Logger;

import de.nobio.pfmsim.runtime.PFMContext;

public class StatisticHandler implements Handler {

    private static final Logger LOGGER = Logger.getLogger(StatisticHandler.class.getName());

    @Override
    public void handle(PFMContext context) {
        String msg = "\nSTAT: Waiting Project:  " + context.getWaitingProjects().size() + " with total workload " + context.getWaitingProjects().getTotalWorkload();
        msg += "\nSTAT: Running Projects: " + context.getRunningProjects().size() + " with total workload " + context.getRunningProjects().getTotalWorkload();
        msg += "\nSTAT: Teams: " + context.getConfiguration().getTeams().size() + "; allocation: " + context.getConfiguration().getTotalAllocation() + "; thereof idle: (to be calculated...)" ;
        
        LOGGER.info("\nSTAT: ********************************************************************");
        LOGGER.info(msg);
        LOGGER.info("\nSTAT: ********************************************************************");
    }

}
