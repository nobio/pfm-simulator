package de.nobio.pfmsim.project;

import java.util.ArrayList;
import java.util.List;

import de.nobio.pfmsim.distribution.Distribution;
import de.nobio.pfmsim.resource.Resource;
import de.nobio.pfmsim.resource.Skill;
import de.nobio.pfmsim.runtime.TimeClock;

public class Project implements TimeClock, Comparable<Project> {

    private String categoryRef;

    private Long priority;

    private Long duration;

    private Category category;

    private Distribution distribution;

    private List<Phase> phases;

    private List<Resource> resources;

    public String getCategoryRef() {
        return categoryRef;
    }

    public Long getPriority() {
        return priority;
    }

    public void setPriority(Long priority) {
        this.priority = priority;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * config of project probability
     */
    public Distribution getDistribution() {
        return distribution;
    }

    public List<Phase> getPhases() {
        return phases;
    }

    public void setPhases(List<Phase> phases) {
        this.phases = phases;
    }

    public List<Resource> getResources() {
        if (resources == null) {
            resources = new ArrayList<Resource>();
        }
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

    public void addResource(Resource resource) {
        getResources().add(resource);
    }

    public List<Resource> getResourcesBySkill(Skill skill) {
        List<Resource> tmp = new ArrayList<Resource>();
        for (Resource resource : getResources()) {
            if (resource.getSkills().contains(skill)) {
                tmp.add(resource);
            }
        }
        return tmp;
    }

    public Long getTotalWorkload() {
        Long workload = 0L;
        for (Phase phase : getPhases()) {
            workload += phase.getWorkload().getWorkload();
        }
        return workload;
    }

    @Override
    public void tick(Long clock) {
        // TODO Auto-generated method stub

    }

    @Override
    public int compareTo(Project p1) {
        int cmp = 0;
        if (p1 == null) {
            cmp = 0;
        } else if (p1.getPriority() > getPriority()) {
            cmp = 1;
        } else if (p1.getPriority() < getPriority()) {
            cmp = -1;
        } else if (p1.getPriority() == getPriority()) {
            cmp = 0;
        }
        return cmp;
    }

    @Override
    public String toString() {
        return "\n\tProject [categoryRef=" + categoryRef + ", priority=" + priority + ", duration=" + duration + ", category=" + category + ", distribution=" + distribution
                + ", phases=" + phases + ", skills=" + resources + "]";
    }

}
