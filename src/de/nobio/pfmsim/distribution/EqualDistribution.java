/**
 * 
 */
package de.nobio.pfmsim.distribution;

import de.nobio.pfmsim.Util;

/**
 * @author nobio
 * @param <T>
 * 
 */
public class EqualDistribution<T> implements IDistribution<Double> {

    private Double start;
    private Double end;

    public EqualDistribution(Double start, Double end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public Double getRandomeValue() {
        return Util.getEquallyDistributedRandomNumer(start, end);
    }

}
