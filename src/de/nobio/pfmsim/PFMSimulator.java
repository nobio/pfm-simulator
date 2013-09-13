package de.nobio.pfmsim;

import java.io.File;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import de.nobio.pfmsim.handler.Handler;
import de.nobio.pfmsim.handler.ProjectInitializer;
import de.nobio.pfmsim.handler.ProjectStarter;
import de.nobio.pfmsim.handler.RepriorisationHandler;
import de.nobio.pfmsim.handler.ReservationHandler;
import de.nobio.pfmsim.handler.ResourceContributionHandler;
import de.nobio.pfmsim.handler.StatisticHandler;
import de.nobio.pfmsim.project.ProjectSetupHandler;
import de.nobio.pfmsim.resource.ResourceSetupHandler;
import de.nobio.pfmsim.runtime.PFMContext;
import de.nobio.pfmsim.runtime.ProjectQueue;
import de.nobio.pfmsim.runtime.Simulation;

public class PFMSimulator {

    private static final Logger LOGGER = Logger.getLogger(PFMSimulator.class.getName());

    private Handler repriorisationHandler = new RepriorisationHandler();
    private Handler projectInitializer = new ProjectInitializer();
    private Handler reservationHandler = new ReservationHandler();
    private Handler projectStarter = new ProjectStarter();
    private Handler resourceContributionHandler = new ResourceContributionHandler();
    private Handler statisticHandler = new StatisticHandler();

    public static void main(String[] args) throws Exception {
        if (args == null || args.length == 0) {
            System.err.println("provide path to properties-xml file");
            System.exit(-1);
        }
        // testDataStructure();
        Simulation cfgSimulation = loadConfiguration(args);
        LOGGER.info(cfgSimulation.toString());

        // setup the context
        PFMContext context = new PFMContext(cfgSimulation, new ProjectQueue(), new ProjectQueue());

        // setup all stuff
        setup(context);

        // let's go: start main loop
//        new PFMSimulator().mainLoop(context);
    }

    private static Simulation loadConfiguration(String[] args) throws JAXBException {
        File file = new File(args[0]);
        JAXBContext jaxbContext = JAXBContext.newInstance(Simulation.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Simulation cfgSimulation = (Simulation) jaxbUnmarshaller.unmarshal(file);
        //        LOGGER.info("loaded config: " + cfgSimulation);
        return cfgSimulation;
    }

    private static void setup(PFMContext context) throws CloneNotSupportedException {
        ResourceSetupHandler resourceSetup = new ResourceSetupHandler();
        resourceSetup.setup(context.getConfiguration());
        resourceSetup.validate(context.getConfiguration());
        
        ProjectSetupHandler projectSetup = new ProjectSetupHandler();
        projectSetup.setup(context.getConfiguration());
        projectSetup.validate(context.getConfiguration());

        LOGGER.info("=======================================================================================");
        LOGGER.info("=================================== Configuration =====================================");
        LOGGER.info("=======================================================================================");
        LOGGER.info(context.getConfiguration().toString());
        LOGGER.info("=======================================================================================");
    }

    private void mainLoop(PFMContext context) throws InterruptedException {

        LOGGER.info("=======================================================================================");
        LOGGER.info("# starting simulation");
        LOGGER.info("=======================================================================================");

        long iterations = context.getConfiguration().getIterations();
        long pause = context.getConfiguration().getPause();
        // iterate over the whole simulation period
        for (int moment = 0; moment <= iterations; moment++) {

            repriorisationHandler.handle(context);
            projectInitializer.handle(context);
            reservationHandler.handle(context);
            projectStarter.handle(context);
            resourceContributionHandler.handle(context);
            statisticHandler.handle(context);

            Thread.sleep(pause);
            LOGGER.info("");

        }

        LOGGER.info("=======================================================================================");
        LOGGER.info("# simulation stopped");
        LOGGER.info("=======================================================================================");
    }

}
