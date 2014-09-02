/**
 * 
 */
package de.nobio.pfmsim.distribution;

import de.nobio.pfmsim.Util;

/**
 * @author nobio
 * 
 * @version $Revision: 1.0 $
 */
public class NormalDistribution<T> implements IDistribution<Double> {

    private Double mean;
    private Double deviation;

    /**
     * Constructor for NormalDistribution.
     * 
     * @param mean
     *            Double
     * @param deviation
     *            Double
     */
    public NormalDistribution(Double mean, Double deviation) {
        this.mean = mean;
        this.deviation = deviation;
    }

    /**
     * Method getRandomeValue.
     * 
     * @return Double
     * @see de.nobio.pfmsim.distribution.IDistribution#getRandomeValue()
     */
    @Override
    public Double getRandomeValue() {
        return Util.getNormallyDistributedRandomNumer(mean, deviation);
    }
}
