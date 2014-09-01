package de.nobio.pfmsim.runtime;

/**
 */
public class PFMContext {

    private Simulation configuration = null;
    private ProjectQueue waitingProjects = null;
    private ProjectQueue runningProjects = null;

    /**
     * Constructor for PFMContext.
     * @param configuration Simulation
     * @param waitingProjects ProjectQueue
     * @param runningProjects ProjectQueue
     */
    public PFMContext(Simulation configuration, ProjectQueue waitingProjects, ProjectQueue runningProjects) {
        super();
        this.configuration = configuration;
        this.waitingProjects = waitingProjects;
        this.runningProjects = runningProjects;
    }

    /**
     * Method getConfiguration.
     * @return Simulation
     */
    public Simulation getConfiguration() {
        return configuration;
    }

    /**
     * Method getWaitingProjects.
     * @return ProjectQueue
     */
    public ProjectQueue getWaitingProjects() {
        return waitingProjects;
    }

    /**
     * Method getRunningProjects.
     * @return ProjectQueue
     */
    public ProjectQueue getRunningProjects() {
        return runningProjects;
    }

}
