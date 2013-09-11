package de.nobio.pfmsim.resource;

import java.util.ArrayList;
import java.util.List;

import de.nobio.pfmsim.Util;
import de.nobio.pfmsim.runtime.Simulation;

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
    public List<Team> setup(Simulation cfgSimulation) throws CloneNotSupportedException {
        List<Team> teams = cfgSimulation.getTeams();

        // check all resources; if availability is 0.0 set the
        // "general availability"
        for (Team team : teams) {
            for (Resource resource : team.getResources()) {
                if (resource.getAvailability() == null) {
                    resource.setAvailability(cfgSimulation.getAvailability());
                }
                List<Skill> tmpSkills = new ArrayList<Skill>();
                for (Skill skill : resource.getSkills()) {
                    tmpSkills.add(cfgSimulation.getSkillFromPool(skill.getRef()));
                }
                resource.getSkills().removeAll(resource.getSkills());
                resource.getSkills().addAll(tmpSkills);
            }
        }

        // clone resources due to their count attribute; when this is "1"
        // leave it; when it is >1 add (n-1) clones
        for (Team team : teams) {
            List<Resource> additionalResources = new ArrayList<Resource>();
            for (Resource resource : team.getResources()) {
                for (int n = 1; n < resource.getCount(); n++) {
                    additionalResources.add(resource.clone());
                }
            }
            team.getResources().addAll(additionalResources);
        }

        return teams;
    }

    public void validate(Simulation config) {
        Util.assertNotNull(config.getAvailability());
        Util.assertNotNull(config.getIterations());
        Util.assertNotNull(config.getPause());
        Util.assertNotNull(config.getPhases());
        Util.assertNotNull(config.getPlanningHorizont());
        Util.assertNotNull(config.getSkillPool());
        Util.assertNotNull(config.getTeams());

        for (Team team : config.getTeams()) {
            Util.assertNotNull(team.getId());
            Util.assertNotNull(team.getResources());
            
            for (Resource resource : team.getResources()) {
                Util.assertNotNull(resource.getAvailability());
                Util.assertNotNull(resource.getCount());
                Util.assertNotNull(resource.getSkills());
                
                for (Skill skill : resource.getSkills()) {
                    Util.assertNotNull(skill.getId());
                    Util.assertNotNull(skill.getName());
                }
                               
            }
        }
    }

}
