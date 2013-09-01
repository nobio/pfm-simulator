package de.nobio.pfmsim.resource;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;

import org.w3c.dom.Element;

import de.nobio.pfmsim.Util;

/**
 * @author nobio
 * 
 */
public class ResourceSetupHandler {

    /**
     * sets up all resources from a configuration
     * 
     * @param resourceConfig
     * @return all resources
     */
    public List<Resource> setup(Element resourceConfig) {
        List<Resource> resources = new ArrayList<Resource>();
        List<Team> teams = new ArrayList<Team>();

        Double generalAvailability = getGeneralAvailability(resourceConfig);
        Util.log("loaded generalAvailability = " + generalAvailability);

        List<Element> elTeams = Util.getChildren("team", resourceConfig);
        Util.log("loaded teams: " + elTeams);
        
        for (Element elTeam : elTeams) {
            Util.log(elTeam);
            Team team = new Team();
            teams.add(team);
            
            // load resources for that team
            
        }

        return resources;
    }

    private Double getGeneralAvailability(Element resourceConfig) {
        return Double.parseDouble(Util.getChildValueFromElement("availability", resourceConfig));
    }

}
