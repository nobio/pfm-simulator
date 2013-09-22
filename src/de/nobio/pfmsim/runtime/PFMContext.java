package de.nobio.pfmsim.runtime;


public class PFMContext {

    private Simulation configuration = null;
    private ProjectQueue waitingProjects = null;
    private ProjectQueue runningProjects = null;

    public PFMContext(Simulation configuration, ProjectQueue waitingProjects, ProjectQueue runningProjects) {
        super();
        this.configuration = configuration;
        this.waitingProjects = waitingProjects;
        this.runningProjects = runningProjects;
    }

    public Simulation getConfiguration() {
        return configuration;
    }

    public ProjectQueue getWaitingProjects() {
        return waitingProjects;
    }

    public ProjectQueue getRunningProjects() {
        return runningProjects;
    }

}
