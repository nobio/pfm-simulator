package de.nobio.pfmsim.distribution;

import java.util.HashMap;
import java.util.Map;

import de.nobio.pfmsim.Util;

/**
 */
public class WeightedDistribution<T> implements IDistribution<String> {

    Map<String, Integer> baseParams = new HashMap<String, Integer>();

    public WeightedDistribution() {
    }

    /**
     * Constructor for WeightedDistribution.
     * 
     * @param baseParams
     *            Map<String,Integer>
     */
    public WeightedDistribution(Map<String, Integer> baseParams) {
        this.baseParams = baseParams;
    }

    /**
     * Method addParam.
     * 
     * @param group
     *            String
     * @param weight
     *            Integer
     */
    public void addParam(String group, Integer weight) {
        baseParams.put(group, weight);
    }

    /**
     * Method getRandomeValue.
     * 
     * @return String
     * @see de.nobio.pfmsim.distribution.IDistribution#getRandomeValue()
     */
    @Override
    public String getRandomeValue() {
        return Util.getWeightedRandomValue(baseParams);
    }

    /**
     * Method toString.
     * 
     * @return String
     */
    @Override
    public String toString() {
        return "WeightedDistribution [baseParams=" + baseParams + "]";
    }

}
