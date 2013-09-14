/**
 * 
 */
package de.nobio.pfmsim.distribution;

import de.nobio.pfmsim.Util;

/**
 * @author nobio
 * 
 */
public class NormalDistribution<T> implements IDistribution<Double> {

    private Double mean;
    private Double deviation;

    public NormalDistribution(Double mean, Double deviation) {
        this.mean = mean;
        this.deviation = deviation;
    }

    @Override
    public Double getRandomeValue() {
        return Util.getNormallyDistributedRandomNumer(mean, deviation);
    }
}
