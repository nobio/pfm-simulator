package de.nobio.pfmsim.project;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "effort_distribution", propOrder = { "type", "param1", "param2", "param3", "param4" })
public class EffortDistribution {
    @XmlAttribute(required = true)
    private String type;
    @XmlElement(required = false)
    private String param1;
    @XmlElement(required = false)
    private String param2;
    @XmlElement(required = false)
    private String param3;
    @XmlElement(required = false)
    private String param4;

    public String getType() {
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
        return "EffortDistribution [type=" + type + ", param1=" + param1 + ", param2=" + param2 + ", param3=" + param3 + ", param4=" + param4 + "]";
    }

}
