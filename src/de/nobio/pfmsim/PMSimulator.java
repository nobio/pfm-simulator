package de.nobio.pfmsim;

import java.io.File;
import java.util.List;
import java.util.Properties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import de.nobio.pfmsim.resource.Resource;
import de.nobio.pfmsim.resource.ResourceSetupHandler;
import de.nobio.pfmsim.resource.Simulation;
import de.nobio.pfmsim.resource.Skill;
import de.nobio.pfmsim.resource.Team;

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
        // List<Project> projects = new
        // ProjectSetupHandler().setup(resourceConfig);
    }

    private static void mainLoop(Long iterations) {
        Util.log(iterations);
    }

    private static void testDataStructure() {

        try {
            Skill skill1 = new Skill();
            skill1.setId("jd");
            skill1.setName("Java Developer");
            Skill skill2 = new Skill();
            skill2.setId("od");
            skill2.setName("Objective-C Developer");

            Resource resource = new Resource();
            resource.setAvailability(0.7);
            resource.getSkills().add(skill1);
            resource.getSkills().add(skill2);

            Team team1 = new Team();
            team1.getResources().add(resource);
            Team team2 = new Team();
            team2.getResources().add(resource);

            Simulation simulation = new Simulation();
            simulation.setAvailability(0.756);
            simulation.setIterations(101L);
            simulation.getTeams().add(team1);
            simulation.getTeams().add(team2);

            JAXBContext jaxbContext = JAXBContext.newInstance(Simulation.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
            marshaller.marshal(simulation, System.out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
