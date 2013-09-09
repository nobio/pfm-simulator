/**
 * 
 */
package de.nobio.pfmsim.handler;

import de.nobio.pfmsim.Util;
import de.nobio.pfmsim.runtime.PFMContext;

/**
 * @author cs6518
 *
 */
public class RepriorisationHandler implements Handler {

    /**
     * @see de.nobio.pfmsim.handler.Handler#handle(de.nobio.pfmsim.runtime.PFMContext)
     */
    @Override
    public void handle(PFMContext context) {
        Util.log(this.getClass().getName());
    }

}
