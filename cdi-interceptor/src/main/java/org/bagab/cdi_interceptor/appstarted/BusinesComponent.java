package org.bagab.cdi_interceptor.appstarted;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * A Rudimentaty business component.
 */
@Stateless
@LocalBean
public class BusinesComponent {

    /**
     * This method can run with Application.isStarted() == false;
     * @param v
     * @return
     */
    public int aBusinesMethod(int v){
        return 0;
    }

    /**
     * This method can run only when Application.isStarted() == true;
     * @param v
     * @return
     */
    @ApplicationStartRequired
    public int anotherBusinesMethod(int v){
        return 1;
    }


}
