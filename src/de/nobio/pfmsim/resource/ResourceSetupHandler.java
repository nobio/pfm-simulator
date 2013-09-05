package de.nobio.pfmsim.resource;

import java.util.ArrayList;
import java.util.List;

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

}
