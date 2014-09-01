package de.nobio.pfmsim.project;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import de.nobio.pfmsim.distribution.Distribution;
import de.nobio.pfmsim.resource.Resource;
import de.nobio.pfmsim.resource.Skill;

/**
 */
public class Project implements Comparable<Project> {

    private static final Logger LOGGER = Logger.getLogger(Project.class.getName());

    /**
     */
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

    private long idleDuration;

    private long runDuration;

    private Category category;

    private Distribution distribution;

    private List<Phase> phases;

    private List<Resource> neededResources;

    private Double allocation = 0D;

    /**
    
     * @return the status */
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

    /**
     * Method getCategoryRef.
     * @return String
     */
    public String getCategoryRef() {
        return categoryRef;
    }

    /**
     * Method getPriority.
     * @return Long
     */
    public Long getPriority() {
        return priority;
    }

    /**
     * Method setPriority.
     * @param priority Long
     */
    public void setPriority(Long priority) {
        this.priority = priority;
    }

    /**
     * Method getDuration.
     * @return Long
     */
    public Long getDuration() {
        return duration;
    }

    /**
     * Method setDuration.
     * @param duration Long
     */
    public void setDuration(Long duration) {
        this.duration = duration;
    }

    /**
     * Method getIdleDuration.
     * @return long
     */
    public long getIdleDuration() {
        return idleDuration;
    }

    /**
     * Method setIdleDuration.
     * @param idleDuration long
     */
    public void setIdleDuration(long idleDuration) {
        this.idleDuration = idleDuration;
    }

    /**
     * Method getRunDuration.
     * @return long
     */
    public long getRunDuration() {
        return runDuration;
    }

    /**
     * Method setRunDuration.
     * @param runDuration long
     */
    public void setRunDuration(long runDuration) {
        this.runDuration = runDuration;
    }

    /**
     * Method getCategory.
     * @return Category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Method setCategory.
     * @param category Category
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * config of project probability
     * @return Distribution
     */
    public Distribution getDistribution() {
        return distribution;
    }

    /**
     * Method getPhases.
     * @return List<Phase>
     */
    public List<Phase> getPhases() {
        return phases;
    }

    /**
     * Method setPhases.
     * @param phases List<Phase>
     */
    public void setPhases(List<Phase> phases) {
        this.phases = phases;
        for (Phase phase : phases) {
            phase.setLinktoProject(this);
        }
    }

    /**
     * Method getNeededResources.
     * @return List<Resource>
     */
    public List<Resource> getNeededResources() {
        if (neededResources == null) {
            neededResources = new ArrayList<Resource>();
        }
        return neededResources;
    }

    /**
     * Method setNeededResources.
     * @param neededResources List<Resource>
     */
    public void setNeededResources(List<Resource> neededResources) {
        this.neededResources = neededResources;
    }

    /**
     * Method addNeededResource.
     * @param resource Resource
     */
    public void addNeededResource(Resource resource) {
        getNeededResources().add(resource);
    }

    /**
     * Method getResourcesBySkill.
     * @param skill Skill
     * @return List<Resource>
     */
    public List<Resource> getResourcesBySkill(Skill skill) {
        List<Resource> tmp = new ArrayList<Resource>();
        for (Resource resource : getNeededResources()) {
            if (resource.getSkills().contains(skill)) {
                tmp.add(resource);
            }
        }
        return tmp;
    }

    /**
     * Method getTotalWorkload.
     * @return Long
     */
    public Long getTotalWorkload() {
        Long workload = 0L;
        for (Phase phase : getPhases()) {
            workload += phase.getWorkload().getWorkload();
        }
        return workload;
    }

    /**
     * Method getTotalAllocation.
     * @return Double
     */
    public Double getTotalAllocation() {
        return allocation;
    }

    /**
     * Method increaseAllocation.
     * @param alloc Double
     */
    public void increaseAllocation(Double alloc) {
        this.allocation += alloc;
        LOGGER.info("Project " + this.hashCode() + " increased the allocation by " + alloc + " to " + allocation);
    }

    /**
     * Method decreaseAllocation.
     * @param alloc Double
     */
    public void decreaseAllocation(Double alloc) {
        this.allocation -= alloc;
        LOGGER.info("Project " + this.hashCode() + " decreased the allocation by " + alloc + " to " + allocation);
    }

    /**
     * Method isAllocated.
     * @return boolean
     */
    public boolean isAllocated() {
        double workload = (double) getTotalWorkload();
        return allocation >= workload;
    }

    /**
     * Method compareTo.
     * @param p1 Project
     * @return int
     */
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
