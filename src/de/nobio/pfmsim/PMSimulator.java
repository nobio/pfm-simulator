package de.nobio.pfmsim;

import java.io.File;
import java.util.List;
import java.util.Properties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import de.nobio.pfmsim.project.Portfolio;
import de.nobio.pfmsim.project.ProjectSetupHandler;
import de.nobio.pfmsim.resource.ResourceSetupHandler;
import de.nobio.pfmsim.resource.Team;
import de.nobio.pfmsim.runtime.Simulation;

public class PMSimulator {

    public static final Properties props = new Properties();

    public static void main(String[] args) throws Exception {
        if (args == null || args.length == 0) {
            System.err.println("provide path to properties-xml file");
            System.exit(-1);
        }
        // testDataStructure();
        Simulation cfgSimulation = loadConfiguration(args);

        // setup all stuff
        setup(cfgSimulation);

        // let's go: start main loop
        mainLoop(cfgSimulation.getIterations());
    }

    private static Simulation loadConfiguration(String[] args) throws JAXBException {
        File file = new File(args[0]);
        JAXBContext jaxbContext = JAXBContext.newInstance(Simulation.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Simulation cfgSimulation = (Simulation) jaxbUnmarshaller.unmarshal(file);
        Util.log("loaded config: " + cfgSimulation);
        return cfgSimulation;
    }

    private static void setup(Simulation cfgSimulation) throws CloneNotSupportedException {
        List<Team> teams = new ResourceSetupHandler().setup(cfgSimulation);
        Util.log(teams);
        Portfolio portfolio = new ProjectSetupHandler().setup(cfgSimulation);
        Util.log(portfolio);
        // Util.test();
    }

    private static void mainLoop(Long iterations) {
        Util.log(iterations);
    }

}
