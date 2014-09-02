/**
 * 
 */
package de.nobio.pfmsim.distribution;

import de.nobio.pfmsim.Util;

/**
 * @author nobio
 * 
 * 
 * @version $Revision: 1.0 $
 */
public class EqualDistribution<T> implements IDistribution<Double> {

    private Double start;
    private Double end;

    /**
     * Constructor for EqualDistribution.
     * 
     * @param start
     *            Double
     * @param end
     *            Double
     */
    public EqualDistribution(Double start, Double end) {
        this.start = start;
        this.end = end;
    }

    /**
     * Method getRandomeValue.
     * 
     * @return Double
     * @see de.nobio.pfmsim.distribution.IDistribution#getRandomeValue()
     */
    @Override
    public Double getRandomeValue() {
        return Util.getEquallyDistributedRandomNumer(start, end);
    }

}
