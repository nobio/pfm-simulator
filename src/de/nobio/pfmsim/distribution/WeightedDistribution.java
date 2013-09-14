package de.nobio.pfmsim.distribution;

import java.util.HashMap;
import java.util.Map;

import de.nobio.pfmsim.Util;

public class WeightedDistribution<T> implements IDistribution<String> {

    Map<String, Integer> baseParams = new HashMap<String, Integer>();

    public WeightedDistribution() {
    }

    public WeightedDistribution(Map<String, Integer> baseParams) {
        this.baseParams = baseParams;
    }

    public void addParam(String group, Integer weight) {
        baseParams.put(group, weight);
    }

    @Override
    public String getRandomeValue() {
        return Util.getWeightedRandomValue(baseParams);
    }

    @Override
    public String toString() {
        return "WeightedDistribution [baseParams=" + baseParams + "]";
    }

}
