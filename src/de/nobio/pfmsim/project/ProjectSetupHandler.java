package de.nobio.pfmsim.project;

import java.util.ArrayList;
import java.util.List;

import de.nobio.pfmsim.runtime.Simulation;

public class ProjectSetupHandler {

    /**
     * adding objects where the configuration only provides references
     * 
     * @param cfgSimulation
     *            the complete
     * @return the configuration of the portfolio
     */
    public Portfolio setup(Simulation cfgSimulation) throws CloneNotSupportedException {

        for (Project project : cfgSimulation.getPortfolio().getProjects()) {

            // setup project category
            for (Category category : cfgSimulation.getProjectCategories()) {
                if (project.getCategoryRef().equals(category.getId())) {
                    project.setCategory(category);
                    break;
                }
            }

            // setup phases
            List<Phase> phases = new ArrayList<Phase>();
            for (Phase phase : project.getPhases()) {
                for (Phase cfgPhase : cfgSimulation.getPhases()) {
                    if (phase.getRef().equals(cfgPhase.getId())) {
                        phases.add((Phase) cfgPhase.clone());
                    }
                }
            }
            project.setPhases(phases);
        }
        return cfgSimulation.getPortfolio();
    }
}
