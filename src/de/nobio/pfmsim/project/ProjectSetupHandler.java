package de.nobio.pfmsim.project;

import java.util.ArrayList;
import java.util.List;

import de.nobio.pfmsim.project.Distribution.DistributionType;
import de.nobio.pfmsim.resource.Skill;
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
            setupCategories(cfgSimulation, project);
            setupPhases(cfgSimulation, project);
            setupNeededSkills(cfgSimulation, project);
            setupProjectCategoryDistribution(cfgSimulation, project);
        }

        return cfgSimulation.getPortfolio();
    }

    private void setupPhases(Simulation cfgSimulation, Project project) throws CloneNotSupportedException {
        // setup phases
        List<Phase> tmpPhases = new ArrayList<Phase>();
        for (Phase phase : project.getPhases()) {
            tmpPhases.add(cfgSimulation.getPhaseFromPool(phase.getRef()));
        }
        project.getPhases().removeAll(project.getPhases());
        project.getPhases().addAll(tmpPhases);
    }

    private void setupCategories(Simulation cfgSimulation, Project project) {
        // setup project category
        Category category = cfgSimulation.getProjectCategoryFromPool(project.getCategoryRef());
        if (category == null) {
            throw new RuntimeException("invalid category reference " + project.getCategoryRef());
        }
        project.setCategory(category);
    }

    private void setupNeededSkills(Simulation cfgSimulation, Project project) {
        // setup skills for this project
        List<Skill> tmpSkills = new ArrayList<Skill>();
        for (Skill skill : project.getSkills()) {
            tmpSkills.add(cfgSimulation.getSkillFromPool(skill.getRef()));
        }
        project.getSkills().removeAll(project.getSkills());
        project.getSkills().addAll(tmpSkills);
    }

    private void setupProjectCategoryDistribution(Simulation cfgSimulation, Project project) {
        if (project.getDistribution() != null && project.getDistribution().getType() == DistributionType.Weighted) {
            String group = project.getCategory().getId();
            Integer weight = Integer.valueOf(project.getDistribution().getParam1());
            cfgSimulation.createProjectCategoryDistribution(DistributionType.Weighted);
            cfgSimulation.getProjectCategoryDistribution().addParamForWeightedDistribution(group, weight);
        }
    }
}
