package de.nobio.pfmsim;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeSet;

/**
 */
public final class Util {

    private static Random rnd = new Random(System.currentTimeMillis());

    /**
     * Returns an equally distributed random number in a given interval
     * 
     * @param start
     *            start of the interval in which the random number is generated
     * @param end
     *            end of the interval in which the random number is generated
    
     * @return an equally distributed random value in an interval [start, end] */
    public final static Double getEquallyDistributedRandomNumer(Double start, Double end) {
        if (start > end) {
            throw new IllegalArgumentException("end (" + end + ") must be greater then start (" + start + ")");
        }
        return start + rnd.nextDouble() * (end - start);
    }

    /**
     * Returns an equally distributed random number in a given interval
     * 
     * @param start
     *            start of the interval in which the random number is generated
     * @param end
     *            end of the interval in which the random number is generated
    
     * @return an equally distributed random value in an interval [start, end] */
    public final static Integer getEquallyDistributedIntRandomNumer(Integer start, Integer end) {
        if (start > end) {
            throw new IllegalArgumentException("end (" + end + ") must be greater then start (" + start + ")");
        }
        return (int) (Math.random() * (end - start) + start);
    }

    /**
     * Returns a normally distributed random number
     * 
     * @param mean
     *            mean value which is the average
     * @param deviation
     *            the standard deviation
    
     * @return a normally distributed random value with mu=mean and
     *         sigma=deviation */
    public final static Double getNormallyDistributedRandomNumer(Double mean, Double deviation) {
        return rnd.nextGaussian() * deviation + mean;
    }

    /**
     * Returns a weighted random value from the given map (key); the weight is
     * given as the value
     * 
     * @param baseParams
     *            : value=the strings weight; key=a group string
    
     * @return one of the given values but be weighted random */
    public final static String getWeightedRandomValue(Map<String, Integer> baseParams) {
        List<String> distribution = new ArrayList<String>();

        for (String weightValue : baseParams.keySet()) {
            for (int i = 0; i < baseParams.get(weightValue); i++) {
                distribution.add(weightValue);
            }
        }
        // int rndIndex = (int) (Math.random() * distribution.size());
        int rndIndex = getEquallyDistributedIntRandomNumer(0, distribution.size());
        return distribution.get(rndIndex);
    }

    /**
     * Method assertNotNull.
     * @param obj Object
     */
    public final static void assertNotNull(Object obj) {
        if (obj == null) {
            throw new RuntimeException("assertion: must not be null");
        }
    }

    /**
     * Method assertEqual.
     * @param obj1 Object
     * @param obj2 Object
     */
    public final static void assertEqual(Object obj1, Object obj2) {
        if (obj1 == null || obj2 == null) {
            throw new RuntimeException("assertion: " + obj1 + " must be equal to " + obj2);
        }
        if (obj1 != null && !obj1.equals(obj2)) {
            throw new RuntimeException("assertion: " + obj1 + " must be equal to " + obj2);
        }
        if (obj2 != null && !obj2.equals(obj1)) {
            throw new RuntimeException("assertion: " + obj1 + " must be equal to " + obj2);
        }
    }

    public final static void test() {
        Map<Long, Integer> distribution = new HashMap<Long, Integer>();
        for (int i = 0; i < 100000; i++) {
            // Double rndval = Util.getNormallyDistributedRandomNumer(10.0,
            // 1.0);
            // Double rndval = Util.getEquallyDistributedRandomNumer(10.0,
            // 20.0);
            Map<String, Integer> baseParams = new HashMap<String, Integer>();
            baseParams.put("1", 1);
            baseParams.put("2", 1);
            baseParams.put("3", 1);
            baseParams.put("4", 3);
            Double rndval = Double.valueOf(Util.getWeightedRandomValue(baseParams));
            Long key = Math.round(rndval);
            if (distribution.get(key) == null) {
                distribution.put(key, 1);
            } else {
                distribution.put(key, distribution.get(key) + 1);
            }
        }
        TreeSet<Long> sortedKeys = new TreeSet<Long>(distribution.keySet());
        System.out.print("distribution {");
        Double sum = 0.0;
        for (Long k : sortedKeys) {
            sum += distribution.get(k);
        }
        for (Long k : sortedKeys) {
            System.out.print(k + "=" + distribution.get(k) + " (" + distribution.get(k) / sum * 100 + "%), ");
        }
        System.out.println("}");

    }
}
