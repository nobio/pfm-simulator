package de.nobio.pfmsim.resource;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private List<Resource> teamMembers = new ArrayList<Resource>();

    public List<Resource> getTeamMembers() {
        return teamMembers;
    }

    public void appendResource(Resource resource) {
        teamMembers.add(resource);
    }

    public void removeResource(Resource resource) {
        teamMembers.remove(resource);
    }

}
