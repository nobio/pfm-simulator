package de.nobio.pfmsim.project;

import java.util.ArrayList;
import java.util.List;

import de.nobio.pfmsim.distribution.Distribution.DistributionType;
import de.nobio.pfmsim.resource.Skill;
import de.nobio.pfmsim.runtime.Simulation;

public class ProjectSetupHandler {

    /**
     * adding objects where the configuration only provides references
     * 
     * @param config
     *            the complete
     * @return the configuration of the portfolio
     */
    public Portfolio setup(Simulation config) throws CloneNotSupportedException {
        setupPhases(config);
        setupNeededSkills(config);
        //        setupProjectCategoryDistribution(config);

        return config.getPortfolio();
    }

    private void setupPhases(Simulation config) throws CloneNotSupportedException {
        // setup phases
        for (Category category : config.getProjectCategoryPool()) {
            List<Phase> tmpPhases = new ArrayList<Phase>();
            for (Phase phase : category.getPhases()) {
                tmpPhases.add(config.getPhaseFromPool(phase.getRef()));
            }
            category.getPhases().removeAll(category.getPhases());
            category.getPhases().addAll(tmpPhases);
        }
    }

    private void setupNeededSkills(Simulation config) {
        // setup skills for this project
        for (Category category : config.getProjectCategoryPool()) {
            List<Skill> tmpSkills = new ArrayList<Skill>();
            for (Skill skill : category.getNeededSkills()) {
                tmpSkills.add(config.getSkillFromPool(skill.getRef()));
            }
            category.getNeededSkills().removeAll(category.getNeededSkills());
            category.getNeededSkills().addAll(tmpSkills);
        }
    }

    private void setupProjectCategoryDistribution(Simulation config, Project project) {
        if (project.getDistribution() != null && project.getDistribution().getType() == DistributionType.Weighted) {
            String group = project.getCategory().getId();
            Integer weight = Integer.valueOf(project.getDistribution().getParam1());
            config.createProjectCategoryDistribution(DistributionType.Weighted);
            config.getProjectCategoryDistribution().addParamForWeightedDistribution(group, weight);
        }
    }

    public void validate(Simulation config) {

    }

}
