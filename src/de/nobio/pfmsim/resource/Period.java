/**
 * 
 */
package de.nobio.pfmsim.resource;

/**
 * @author nobio
 * 
 *         represents a start date and an end date of a not disrupted time span
 * @version $Revision: 1.0 $
 */
public class Period {

    private int begin;
    private int end;

    public Period() {
        super();
    }

    /**
     * Constructor for Period.
     * @param begin int
     * @param end int
     */
    public Period(int begin, int end) {
        super();
        this.begin = begin;
        this.end = end;
    }

    /**
    
     * @return the begin */
    public int getBegin() {
        return begin;
    }

    /**
     * @param begin
     *            the begin to set
     */
    public void setBegin(int begin) {
        this.begin = begin;
    }

    /**
    
     * @return the end */
    public int getEnd() {
        return end;
    }

    /**
     * @param end
     *            the end to set
     */
    public void setEnd(int end) {
        this.end = end;
    }

    /**
     * Method isValid.
     * @return boolean
     */
    public boolean isValid() {
        return end >= 0 && begin >= 0;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Period [begin=" + begin + ", end=" + end + "]";
    }

}
