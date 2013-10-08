package de.nobio.pfmsim.project;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import de.nobio.pfmsim.distribution.Distribution;
import de.nobio.pfmsim.resource.Resource;
import de.nobio.pfmsim.resource.Skill;
import de.nobio.pfmsim.runtime.TimeClock;

public class Project implements TimeClock, Comparable<Project> {

    private static final Logger LOGGER = Logger.getLogger(Project.class.getName());

    public enum ProjectStatus {
        Waiting, // project initialized and now waiting to be started; usually
                 // projects in WaitingQueue are in status WAITING
        Allocated, // project's resources are allocated; project could be
                   // started
        Running, // running project
        Finished // finished project
    }

    private ProjectStatus status = ProjectStatus.Waiting;

    private String categoryRef;

    private Long priority;

    private Long duration;

    private Category category;

    private Distribution distribution;

    private List<Phase> phases;

    private List<Resource> neededResources;

    private Double allocation = 0D;

    /**
     * @return the status
     */
    public ProjectStatus getStatus() {
        return status;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(ProjectStatus status) {
        this.status = status;
    }

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
        for (Phase phase : phases) {
            phase.setLinktoProject(this);
        }
    }

    public List<Resource> getNeededResources() {
        if (neededResources == null) {
            neededResources = new ArrayList<Resource>();
        }
        return neededResources;
    }

    public void setNeededResources(List<Resource> neededResources) {
        this.neededResources = neededResources;
    }

    public void addNeededResource(Resource resource) {
        getNeededResources().add(resource);
    }

    public List<Resource> getResourcesBySkill(Skill skill) {
        List<Resource> tmp = new ArrayList<Resource>();
        for (Resource resource : getNeededResources()) {
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

    public Double getTotalAllocation() {
        return allocation;
    }

    public void increaseAllocation(Double alloc) {
        this.allocation += alloc;
        LOGGER.info("Project " + this.hashCode() + " increased the allocation by " + alloc + " to " + allocation);
    }

    public void decreaseAllocation(Double alloc) {
        this.allocation -= alloc;
        LOGGER.info("Project " + this.hashCode() + " decreased the allocation by " + alloc + " to " + allocation);
    }

    public boolean isAllocated() {
        return allocation >= (double) getTotalWorkload();
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

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "\n\tProject [status=" + status + ", categoryRef=" + categoryRef + ", priority=" + priority + ", duration=" + duration + ", category=" + category
                + ", distribution=" + distribution + ", phases=" + phases + ", neededResources=" + neededResources + "]";
    }

}
