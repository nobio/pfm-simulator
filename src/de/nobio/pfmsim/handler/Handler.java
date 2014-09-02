package de.nobio.pfmsim.handler;

import de.nobio.pfmsim.runtime.PFMContext;

/**
 */
public interface Handler {

    /**
     * Method handle.
     * 
     * @param context
     *            PFMContext
     * @throws Exception
     */
    public void handle(PFMContext context) throws Exception;

}
