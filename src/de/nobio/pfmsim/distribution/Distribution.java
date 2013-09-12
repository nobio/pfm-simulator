package de.nobio.pfmsim.distribution;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "distribution", propOrder = { "type", "param1", "param2", "param3", "param4", "param5", "param6", "param7", "param8", "param9", "param10" })
public class Distribution {

    @XmlTransient
    Map<String, Integer> baseParamsForWeightedDistribution = new HashMap<String, Integer>();

    @XmlEnum
    public enum DistributionType {
        Constant, // always the same (???)
        Equal, // equal distribution
        Normal, // normal (gaussian) distribution
        Weighted, // weighted distribution
        Rectangle // todo: some shaped distribution
    }

    @XmlAttribute(required = true)
    private DistributionType type;

    @XmlElement(required = false)
    private String param1;

    @XmlElement(required = false)
    private String param2;

    @XmlElement(required = false)
    private String param3;

    @XmlElement(required = false)
    private String param4;

    @XmlElement(required = false)
    private String param5;

    @XmlElement(required = false)
    private String param6;

    @XmlElement(required = false)
    private String param7;

    @XmlElement(required = false)
    private String param8;

    @XmlElement(required = false)
    private String param9;

    @XmlElement(required = false)
    private String param10;

    @SuppressWarnings("rawtypes")
    @XmlTransient
    private IDistribution distribution;

    /**
     * Default constructor
     */
    public Distribution() {
        super();
    }

    public Distribution(DistributionType type) {
        super();
        this.type = type;
        initDistribution();
    }

    public DistributionType getType() {
        return type;
    }

    public String getParam1() {
        return param1;
    }

    public String getParam2() {
        return param2;
    }

    public String getParam3() {
        return param3;
    }

    public String getParam4() {
        return param4;
    }

    public String getParam5() {
        return param5;
    }

    public String getParam6() {
        return param6;
    }

    public String getParam7() {
        return param7;
    }

    public String getParam8() {
        return param8;
    }

    public String getParam9() {
        return param9;
    }

    public String getParam10() {
        return param10;
    }

    public void addParamForWeightedDistribution(String group, Integer weight) {
        if (this.type == DistributionType.Weighted) {
            @SuppressWarnings("unchecked")
            WeightedDistribution<String> weightedDistribution = (WeightedDistribution<String>) distribution;
            weightedDistribution.addParam(group, weight);
        } else {
            throw new RuntimeException("you cannot add parameters for a weighted random value when this distribution was not defined as a weighted distribution");
        }
    }

    public Double getRandomNumericValue() {

        if (type == null) {
            throw new RuntimeException("ne distribution type defined");
        }
        if (type == DistributionType.Weighted) {
            throw new RuntimeException("you cannot ask for a numeric random value when this distribution was defined as a weighted distribution");
        }

        initDistribution();

        return (Double) distribution.getRandomeValue();
    }

    public String getRandomWeightedValue() {

        if (type == null) {
            throw new RuntimeException("ne distribution type defined");
        }
        if (type != DistributionType.Weighted) {
            throw new RuntimeException("you cannot ask for a weighted random value when this distribution was not defined as a weighted distribution");
        }

        initDistribution();

        return (String) distribution.getRandomeValue();
    }

    private void initDistribution() {
        if (distribution == null) {
            switch (type) {
            case Equal:
                distribution = new EqualDistribution<Double>(Double.valueOf(param1), Double.valueOf(param2));
                break;
            case Normal:
                distribution = new NormalDistribution<Double>(Double.valueOf(param1), Double.valueOf(param2));
                break;
            case Weighted:
                distribution = new WeightedDistribution<String>(baseParamsForWeightedDistribution);
                break;
            default:
                distribution = null;
            }
        }
    }

    @Override
    public String toString() {
        String strP1 = param1 != null ? ", param1=" + param1 : "";
        String strP2 = param2 != null ? ", param2=" + param2 : "";
        String strP3 = param3 != null ? ", param3=" + param3 : "";
        String strP4 = param4 != null ? ", param4=" + param4 : "";
        String strP5 = param5 != null ? ", param5=" + param5 : "";
        String strP6 = param6 != null ? ", param6=" + param6 : "";
        String strP7 = param7 != null ? ", param7=" + param7 : "";
        String strP8 = param8 != null ? ", param8=" + param8 : "";
        String strP9 = param9 != null ? ", param9=" + param9 : "";
        String strP10 = param10 != null ? ", param10=" + param10 : "";
        return "Distribution [type=" + type + strP1 + strP2 + strP3 + strP4 + strP5 + strP6 + strP7 + strP8 + strP9 + strP10 + "]";
    }

}
