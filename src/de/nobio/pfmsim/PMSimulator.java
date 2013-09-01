package de.nobio.pfmsim;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import de.nobio.pfmsim.project.Project;
import de.nobio.pfmsim.project.ProjectSetupHandler;
import de.nobio.pfmsim.resource.Resource;
import de.nobio.pfmsim.resource.ResourceSetupHandler;

public class PMSimulator {

    public static final Properties props = new Properties();

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        if (args == null || args.length == 0) {
            System.err.println("provide path to properties-xml file");
            System.exit(-1);
        }

        Document doc = readXMLProperties(args);

        Node simulation = doc.getFirstChild();

        Element it = (Element) doc.getElementsByTagName("iterations").item(0);
        Long iterations = Long.parseLong(it.getTextContent());
        Element resources = (Element) doc.getElementsByTagName("resources").item(0);
        Element portfolio = (Element) doc.getElementsByTagName("portfolio").item(0);

        // setup all stuff
        setup(simulation, resources, portfolio);

        // let's go: start main loop
        mainLoop(iterations);
    }

    private static Document readXMLProperties(String[] args) throws ParserConfigurationException, SAXException, IOException {
        File fXmlFile = new File(args[0]);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        doc.getDocumentElement().normalize();
        return doc;
    }

    private static void setup(Node simulation, Element resourceConfig, Element portfolioConfig) {
        List<Resource> resources = new ResourceSetupHandler().setup(resourceConfig);
        List<Project> projects = new ProjectSetupHandler().setup(resourceConfig);
    }

    private static void mainLoop(Long iterations) {
        Util.log(iterations);
    }
}
