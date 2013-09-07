package de.nobio.pfmsim.project;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "distribution", propOrder = { "type", "param1", "param2", "param3", "param4" })
public class Distribution {

    @XmlEnum
    public enum DistributionType {
        Constant, Equal, Normal, Weighted, Rectangle
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

    @Override
    public String toString() {
        return "Distribution [type=" + type + ", param1=" + param1 + ", param2=" + param2 + ", param3=" + param3 + ", param4=" + param4 + "]";
    }

}
