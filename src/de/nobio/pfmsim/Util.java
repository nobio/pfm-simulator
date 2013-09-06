package de.nobio.pfmsim;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeSet;

public final class Util {

    static Random rnd = new Random(System.currentTimeMillis());

    public final static void log(Object message) {
        System.out.println("DEBUG " + message.toString());
    }

    /**
     * Returns an equally distributed random number in a given interval
     * 
     * @param start start of the interval in which the random number is generated
     * @param end end of the interval in which the random number is generated
     * @return an equally distributed random value in an interval [start, end]
     */
    public final static Double getEquallyDistributedRandomNumer(Double start, Double end) {
        if (start > end) {
            throw new IllegalArgumentException("end must be greater then start");
        }
        return start + rnd.nextDouble() * (end - start);
    }

    /**
     * Returns a normally distributed random number
     * 
     * @param mean mean value which is the average
     * @param deviation the standard deviation
     * @return a normally distributed random value with mu=mean and sigma=deviation
     */
    public final static Double getNormallyDistributedRandomNumer(Double mean, Double deviation) {
        return rnd.nextGaussian() * deviation + mean;
    }

    /**
     * Returns a normally distributed random number
     * 
     * @param mean mean value which is the average
     * @param deviation the standard deviation
     * @return a normally distributed random value with mu=mean and sigma=deviation
     */
    public final static String getWeightedRandomValue(Map<String, Integer> baseParams) {
        List<String> distribution = new ArrayList<String>();

        for (String weightValue : baseParams.keySet()) {
            for (int i = 0; i < baseParams.get(weightValue); i++) {
                distribution.add(weightValue);
            }
        }
        Double rnd = Math.ceil(getEquallyDistributedRandomNumer(0.0, (double) distribution.size() - 1));
        //        long rndValue = Math.round(rnd);
        String strValue = String.valueOf(rnd);
        strValue = strValue.substring(0, strValue.indexOf("."));
        //        System.out.println(distribution + " " + rnd + " ceil:" + Math.floor(rnd) + "/ " + rndValue + " "
        //                + distribution.get(Integer.valueOf(String.valueOf(rndValue))));
        return distribution.get(Integer.valueOf(strValue));
    }

    public final static void test() {
        Map<Long, Integer> distribution = new HashMap<Long, Integer>();
        for (int i = 0; i < 100000; i++) {
            //            Double rndval = Util.getNormallyDistributedRandomNumer(10.0, 1.0);
            //            Double rndval = Util.getEquallyDistributedRandomNumer(10.0, 20.0);
            Map<String, Integer> baseParams = new HashMap<String, Integer>();
            baseParams.put("200", 4);
            baseParams.put("100", 1);
            //            baseParams.put("300", 1);
            //            baseParams.put("400", 1);
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
