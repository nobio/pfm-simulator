package de.nobio.pfmsim.project;

import java.util.ArrayList;
import java.util.List;

import de.nobio.pfmsim.distribution.Distribution.DistributionType;
import de.nobio.pfmsim.distribution.WeightedDistribution;
import de.nobio.pfmsim.resource.Skill;
import de.nobio.pfmsim.runtime.Simulation;

/**
 */
public class ProjectSetupHandler {

    /**
     * adding objects where the configuration only provides references
     * 
     * @param config
     *            the complete
     * 
     * @return the configuration of the portfolio * @throws
     *         CloneNotSupportedException
     */
    public Portfolio setup(Simulation config) throws CloneNotSupportedException {
        setupPhases(config);
        setupNeededSkills(config);
        setupProjectCategoryDistribution(config);

        return config.getPortfolio();
    }

    /**
     * Method setupNeededSkills.
     * 
     * @param config
     *            Simulation
     */
    private void setupNeededSkills(Simulation config) {
        // setup skills for this project
        for (Category category : config.getProjectCategoryPool()) {
            WeightedDistribution<String> skillDistribution = new WeightedDistribution<String>();
            for (Skill skill : category.getNeededSkills()) {
                Skill referenceSkill = config.getSkillFromPool(skill.getRef());
                skill.setId(referenceSkill.getId());
                skill.setName(referenceSkill.getName());

                Integer weight = Integer.valueOf(skill.getDistribution().getParam1());
                String group = skill.getId();
                skillDistribution.addParam(group, weight);
            }
        }
    }

    /**
     * Method setupPhases.
     * 
     * @param config
     *            Simulation
     * @throws CloneNotSupportedException
     */
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

    /**
     * Method setupProjectCategoryDistribution.
     * 
     * @param config
     *            Simulation
     */
    private void setupProjectCategoryDistribution(Simulation config) {
        WeightedDistribution<String> projectCategoryDistribution = new WeightedDistribution<String>();
        for (Category category : config.getProjectCategoryPool()) {
            if (category.getProjectCategoryDistribution().getType() != DistributionType.Weighted) {
                throw new IllegalArgumentException("Distrtibution of skills must be weighted");
            }
            String group = category.getId();
            Integer weight = Integer.valueOf(category.getProjectCategoryDistribution().getParam1());
            projectCategoryDistribution.addParam(group, weight);
        }
        config.setProjectCategoryDistribution(projectCategoryDistribution);
    }

    /**
     * Method validate.
     * 
     * @param config
     *            Simulation
     */
    public void validate(Simulation config) {

    }

}
