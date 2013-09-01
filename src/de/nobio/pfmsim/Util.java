package de.nobio.pfmsim;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public final class Util {

    public final static String getChildValueFromElement(String tagname, Element element) {

        String returnValue = null;
        NodeList nodelist = element.getChildNodes();
        for (int n = 0; n < nodelist.getLength(); n++) {
            Node node = nodelist.item(n);

            if (node.getNodeType() == Node.ELEMENT_NODE && tagname.equals(node.getNodeName())) {
                returnValue = node.getTextContent();
            }
        }
        return returnValue;
    }
    
    public final static List<Element> getChildren(String tagname, Element element) {

        List<Element>  returnValue = new ArrayList<Element>();
        NodeList nodelist = element.getChildNodes();
        for (int n = 0; n < nodelist.getLength(); n++) {
            Node node = nodelist.item(n);

            if (node.getNodeType() == Node.ELEMENT_NODE && tagname.equals(node.getNodeName())) {
                returnValue.add((Element)node);
            }
        }
        return returnValue;
    }
    
    

    public final static void log(Object message) {
        System.out.println("DEBUG " + message.toString());
    }
}
